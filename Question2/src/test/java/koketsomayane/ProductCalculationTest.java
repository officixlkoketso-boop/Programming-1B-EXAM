/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package koketsomayane;

/**
 *
 * @author Student
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductCalculationTest {
    @Test
    void GetVat_WithValidData_ReturnCorrectValue() {
        ProductCalculation calculation = new ProductCalculation(3500.0);
        assertEquals(525.0, calculation.GetVat());
    }

    @Test
    void GetTotal_WithValidData_ReturnCorrectValue() {
        ProductCalculation calculation = new ProductCalculation(3500.0);
        assertEquals(4200.0, calculation.GetTotalSales());
    }
}
