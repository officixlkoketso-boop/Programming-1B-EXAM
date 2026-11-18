package koketsomayane;

public class ProductCalculation implements IProductCalculation {
    private double productPrice;

    public ProductCalculation(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public double GetVat() {
        return productPrice * 0.15;
    }

    @Override
    public double GetCommission() {
        return productPrice * 0.05;
    }

    @Override
    public double GetTotalSales() {
        return productPrice + GetVat() + GetCommission();
    }
}
