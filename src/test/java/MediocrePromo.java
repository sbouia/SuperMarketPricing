import promotions.Promo;

public class MediocrePromo implements Promo {
    @Override
    public double calculate(double articleNbr, double unitPrice) {
        return 3;
    }
}
