package promotions;

public class PromoThreeForDollar implements Promo {
    @Override
    public double calculate(double articleNbr, double unitPrice) {
        if (articleNbr == 3)
            return 1;
        else return articleNbr * unitPrice;
    }
}
