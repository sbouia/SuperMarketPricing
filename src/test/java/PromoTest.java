import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import promotions.Promo;
import promotions.PromoThreeForDollar;

class PromoTest {

    private static Promo promoThreeForDollar = new PromoThreeForDollar();

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

}
