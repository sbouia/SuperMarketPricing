package promotions;

public class PromoThreeForDollar implements Promo {
    @Override
    public double calculate(double articleNbr, double unitPrice) {
        return (articleNbr % 3) * unitPrice + (int) (articleNbr / 3);
    }
}
