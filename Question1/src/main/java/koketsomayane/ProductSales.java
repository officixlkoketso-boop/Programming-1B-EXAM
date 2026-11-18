/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package koketsomayane;

/**
 *
 * @author Student
 */

public class ProductSales implements IProductSales {
    @Override
    public int GetTotalProductSales(int[][] sales) {
        //adding all product sales
        int total = 0;
        for (int product = 0; product < sales.length; product++) {
            for (int month = 0; month < sales[product].length; month++) {
                total = total + sales[product][month];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold(int[][] sales) {
        //calculating the average sales
        int total = GetTotalProductSales(sales);
        int numberOfSales = 0;
        for (int product = 0; product < sales.length; product++) {
            numberOfSales = numberOfSales + sales[product].length;
        }
        return total / (double) numberOfSales;
    }

    @Override
    public String GetMostPopularProducts(int[][] sales, String[] productNames) {
        //finding the product with the highest sales
        int mostPopularProduct = 0;
        int highestSales = 0;
        for (int product = 0; product < sales.length; product++) {
            int productTotal = 0;
            for (int month = 0; month < sales[product].length; month++) {
                productTotal = productTotal + sales[product][month];
            }
            if (productTotal > highestSales) {
                mostPopularProduct = product;
                highestSales = productTotal;
            }
        }
        return productNames[mostPopularProduct];
    }
}
