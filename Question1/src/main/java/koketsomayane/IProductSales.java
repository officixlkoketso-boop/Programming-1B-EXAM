package koketsomayane;

public interface IProductSales {
    int GetTotalProductSales(int[][] sales);
    double GetAverageProductSold(int[][] sales);
    String GetMostPopularProducts(int[][] sales, String[] productNames);
}
