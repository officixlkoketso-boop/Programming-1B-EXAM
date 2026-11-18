/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package koketsomayane;

/**
 *
 * @author Student
 */

public class ProductCalculation implements IProductCalculation {
    private double productPrice;

    public ProductCalculation(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public double GetVat() {
        //calculating VAT
        return productPrice * 0.15;
    }

    @Override
    public double GetCommission() {
        //calculating commission
        return productPrice * 0.05;
    }

    @Override
    public double GetTotalSales() {
        //calculating the total sales amount
        return productPrice + GetVat() + GetCommission();
    }
}
