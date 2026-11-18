package koketsomayane;

public class PrintOut {
    public void PrintTotalProductSales(ProductSales products, int[][] sales) {
        System.out.println("TOTAL PRODUCT SALES: " + products.GetTotalProductSales(sales));
    }

    public void PrintAverageProductSold(ProductSales products, int[][] sales) {
        System.out.println("AVERAGE PRODUCT SALES: " + products.GetAverageProductSold(sales));
    }

    public void PrintMostPopularProducts(ProductSales products, int[][] sales, String[] productNames) {
        System.out.println("MOST POPULAR PRODUCT: " + products.GetMostPopularProducts(sales, productNames));
    }

    public void PrintProducts(int[][] sales, String[] productNames) {
        for (int product = 0; product < productNames.length; product++) {
            int productTotal = 0;
            System.out.print(productNames[product] + ": ");
            for (int month = 0; month < sales[product].length; month++) {
                System.out.print("month " + (month + 1) + " = " + sales[product][month]);
                if (month < sales[product].length - 1) {
                    System.out.print(", ");
                }
                productTotal = productTotal + sales[product][month];
            }
            System.out.println(" (total = " + productTotal + ")");
        }
    }
}
