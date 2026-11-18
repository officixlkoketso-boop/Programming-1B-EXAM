/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package koketsomayane;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class ProductSalesReport {
    public static void main(String[] args) {
        //array with product names
        String[] productNames = {
            "Cozy Nights Monarch Mattress",
            "Restonic Barbados Mattress",
            "Sealy Phuket Mattress"
        };
        //array with product sales
        int[][] sales = new int[3][3];
        Scanner input = new Scanner(System.in);

        //getting the sales from the user
        for (int product = 0; product < productNames.length; product++) {
            for (int month = 0; month < 3; month++) {
                System.out.print("Enter number of sales for month " + (month + 1)
                        + " for " + productNames[product] + ": ");
                sales[product][month] = input.nextInt();
            }
        }

        ProductSales products = new ProductSales();
        PrintOut report = new PrintOut();
        //printing the report
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("******************");
        report.PrintTotalProductSales(products, sales);
        report.PrintAverageProductSold(products, sales);
        report.PrintMostPopularProducts(products, sales, productNames);
        input.close();
    }
}
