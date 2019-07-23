package promotions;

public class PromoBuyTwoGetOneFree implements Promo {
    @Override
    public double calculate(double articleNbr, double unitPrice) {
        double rest = articleNbr;
        double total = 0;
        while (rest > 2) {
            total += unitPrice * 2;
            rest -= 3;
        }
        total += rest * unitPrice;
        return total;
    }
}
