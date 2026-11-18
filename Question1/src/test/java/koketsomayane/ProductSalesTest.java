package koketsomayane;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductSalesTest {
    private final int[][] sales = {
        {20, 20, 20},
        {15, 17, 18},
        {14, 14, 15}
    };
    private final ProductSales products = new ProductSales();

    @Test
    void GetTotalProductSales_WithValidData_ReturnCorrectValue() {
        assertEquals(153, products.GetTotalProductSales(sales));
    }

    @Test
    void GetAverageProductSold_ReturnsCorrectValue() {
        assertEquals(17.0, products.GetAverageProductSold(sales));
    }

    @Test
    void GetMostPopularProducts_ReturnsProductWithHighestTotalSales() {
        String[] productNames = {
            "Cozy Nights Monarch Mattress",
            "Restonic Barbados Mattress",
            "Sealy Phuket Mattress"
        };
        assertEquals("Cozy Nights Monarch Mattress", products.GetMostPopularProducts(sales, productNames));
    }
}
