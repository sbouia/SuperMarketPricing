import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import promotions.Promo;
import promotions.PromoBuyTwoGetOneFree;
import promotions.PromoThreeForDollar;

class PromoTest {

    private static Promo promoThreeForDollar = new PromoThreeForDollar();
    private static Promo promoBuyTwoGetOneFree = new PromoBuyTwoGetOneFree();

    @Test
    void should_return_one_dollar_for_three_articles() {
        //Given
        double promoArticleNbr = 3;
        double unitPrice = 0.5;
        //When
        double result = promoThreeForDollar.calculate(promoArticleNbr, unitPrice);
        //Then
        Assertions.assertEquals(1, result);
    }

    @Test
    void should_return_total_for_quantity_diff_then_three() {
        //Given
        double promoArticleNbr = 3;
        double quantityBought = promoArticleNbr + 2;
        double unitPrice = 0.5;
        //When
        double result = promoThreeForDollar.calculate(quantityBought, unitPrice);
        //Then
        Assertions.assertEquals(2, result);
    }

    @Test
    void should_return_price_of_two_when_buying_three() {
        //Given
        double articleNbr = 3;
        double unitPrice = 0.5;
        //When
        double result = promoBuyTwoGetOneFree.calculate(articleNbr, unitPrice);
        //Then
        Assertions.assertEquals(1, result);
    }

}
