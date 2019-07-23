import promotions.Promo;

public class GoodPromo implements Promo {
    @Override
    public double calculate(double articleNbr, double unitPrice) {
        return 2;
    }
}
