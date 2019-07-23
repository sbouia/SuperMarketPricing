import entities.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pricing.PricingService;
import promotions.Promo;
import promotions.PromoBuyTwoGetOneFree;
import promotions.PromoThreeForDollar;

import java.util.Optional;

class PromoTest {

    private static Promo promoThreeForDollar = new PromoThreeForDollar();
    private static Promo promoBuyTwoGetOneFree = new PromoBuyTwoGetOneFree();
    private static PricingService pricingService = new PricingService();

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

    @Test
    void should_return_price_when_quantity_different_then_three() {
        //Given
        double articleNbr = 7;
        double unitPrice = 0.5;
        //When
        double result = promoBuyTwoGetOneFree.calculate(articleNbr, unitPrice);
        //Then
        Assertions.assertEquals(2.5, result);
    }

    @Test
    void should_return_promo() {
        //Given
        Article article = new Article("article1", 100);
        Promo bestPromoMock = new BestPromo();
        Promo goodPromoMock = new GoodPromo();
        Promo mediocrePromoMock = new MediocrePromo();
        article.getPromos().add(bestPromoMock);
        article.getPromos().add(goodPromoMock);
        article.getPromos().add(mediocrePromoMock);
        //when
        Optional<Promo> bestPromo = pricingService.bestPromo(article);
        //Then
        Assertions.assertTrue(bestPromo.isPresent());
        Assertions.assertEquals(bestPromo.get(), bestPromoMock);
    }

}

