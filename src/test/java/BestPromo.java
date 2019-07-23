import promotions.Promo;

public class BestPromo implements Promo {

    @Override
    public double calculate(double articleNbr, double unitPrice) {
        return 1;
    }
}
