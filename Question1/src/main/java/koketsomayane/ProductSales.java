package koketsomayane;

public class ProductSales implements IProductSales {
    @Override
    public int GetTotalProductSales(int[][] sales) {
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
        int total = GetTotalProductSales(sales);
        int numberOfSales = 0;
        for (int product = 0; product < sales.length; product++) {
            numberOfSales = numberOfSales + sales[product].length;
        }
        return total / (double) numberOfSales;
    }

    @Override
    public String GetMostPopularProducts(int[][] sales, String[] productNames) {
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
