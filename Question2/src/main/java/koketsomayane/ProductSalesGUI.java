package koketsomayane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ProductSalesGUI extends JFrame {
    private final JTextField customerNameField = new JTextField();
    private final JComboBox<String> productComboBox = new JComboBox<String>(new String[] {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    });
    private final JTextField priceField = new JTextField();

    public ProductSalesGUI() {
        setTitle("Product App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CreateMenu();
        CreateForm();

        setSize(550, 300);
        setLocationRelativeTo(null);
    }

    private void CreateMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(event -> ProcessSale());
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(event -> ClearFields());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    private void CreateForm() {
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Customer Name:"));
        formPanel.add(customerNameField);

        formPanel.add(new JLabel("Select Product:"));
        formPanel.add(productComboBox);

        formPanel.add(new JLabel("Enter Price:"));
        formPanel.add(priceField);

        JButton processButton = new JButton("PROCESS");
        processButton.addActionListener(event -> ProcessSale());
        formPanel.add(new JLabel(""));
        formPanel.add(processButton);

        add(formPanel, BorderLayout.CENTER);
    }

    private void ProcessSale() {
        String customerName = customerNameField.getText().trim();
        String productName = (String) productComboBox.getSelectedItem();
        String priceText = priceField.getText().trim();

        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the customer's name.");
            return;
        }

        double productPrice;
        try {
            productPrice = Double.parseDouble(priceText);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Enter a valid product price.");
            return;
        }

        if (productPrice <= 0 || Double.isNaN(productPrice) || Double.isInfinite(productPrice)) {
            JOptionPane.showMessageDialog(this, "Enter a price greater than zero.");
            return;
        }

        ProductCalculation calculation = new ProductCalculation(productPrice);
        double vat = calculation.GetVat();
        double commission = calculation.GetCommission();
        double total = calculation.GetTotalSales();

        if (!SaveSale(customerName, productName, vat, commission, total)) {
            return;
        }

        String message = "Customer Name: " + customerName
                + " Product: " + productName
                + " VAT: R " + vat
                + " COMMISSION: R " + commission
                + " TOTAL: R " + total;
        JOptionPane.showMessageDialog(this, message, "Sale Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean SaveSale(String customerName, String productName,
            double vat, double commission, double total) {
        try (FileWriter writer = new FileWriter("data.txt", true)) {
            writer.write("DATA LOG ");
            writer.write("****************************** ");
            writer.write("Customer Name: " + customerName + " ");
            writer.write("Product: " + productName + " ");
            writer.write("VAT: R " + vat + " ");
            writer.write("COMMISSION: R " + commission + " ");
            writer.write("TOTAL: R " + total + " ");
            return true;
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(this, "Could not save sale details to data.txt.");
            return false;
        }
    }

    private void ClearFields() {
        customerNameField.setText("");
        productComboBox.setSelectedIndex(0);
        priceField.setText("");
    }

    public static void main(String[] args) {
        new ProductSalesGUI().setVisible(true);
    }
}
