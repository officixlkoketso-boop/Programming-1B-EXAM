/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package koketsomayane;

/**
 *
 * @author Student
 */

public interface IProductSales {
    int GetTotalProductSales(int[][] sales);
    double GetAverageProductSold(int[][] sales);
    String GetMostPopularProducts(int[][] sales, String[] productNames);
}
