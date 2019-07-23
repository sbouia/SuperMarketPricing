import dto.ArticleWithQuantity;
import entities.Article;
import entities.Unity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pricing.PricingService;
import promotions.Promo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class PricingTest {

    private static PricingService pricingService = new PricingService();
    private static Promo goodPromoMock = new GoodPromo();
    private static Promo bestPromoMock = new BestPromo();
    private static Promo mediocrePromoMock = new MediocrePromo();

    @Test
    void test() {
        Assertions.assertTrue(true);
    }

    @Test
    void should_calculate_total_amount_of_bought_articles() {
        //Given
        Article article1 = new Article("article1", 100);
        Article article2 = new Article("article2", 50);
        ArticleWithQuantity articleWithQuantity1 = new ArticleWithQuantity(article1, 3);
        ArticleWithQuantity articleWithQuantity2 = new ArticleWithQuantity(article2, 2);
        Set<ArticleWithQuantity> articleWithQuantities = new HashSet<>(Arrays.asList(articleWithQuantity1, articleWithQuantity2));
        //When
        double result = pricingService.calculateTotal(articleWithQuantities);
        //Then
        Assertions.assertEquals(400, result);

    }

    @Test
    void should_calculate_total_amount_of_bought_weighted_articles() {
        //Given
        Article article1 = new Article("article1", 100.00);
        Article article2 = new Article("article2", 50.00);
        ArticleWithQuantity articleWithQuantity1 = new ArticleWithQuantity(article1, 3.2);
        ArticleWithQuantity articleWithQuantity2 = new ArticleWithQuantity(article2, 2.5);
        Set<ArticleWithQuantity> articleWithQuantities = new HashSet<>(Arrays.asList(articleWithQuantity1, articleWithQuantity2));
        //When
        double result = pricingService.calculateTotal(articleWithQuantities);
        //Then
        Assertions.assertEquals(445d, result);
    }

    @Test
    void should_calculate_total_amount_of_bought_weighted_articles_in_ounces() {
        //Given
        double priceForPound = 100.00;
        Article article = new Article("article1", priceForPound, Unity.POUND);
        double quantityInOunce = 3.2;
        ArticleWithQuantity articleWithQuantity = new ArticleWithQuantity(article, Unity.OUNCE.convertToPound(quantityInOunce));
        Set<ArticleWithQuantity> articleWithQuantities = new HashSet<>(Collections.singletonList(articleWithQuantity));
        //When
        double result = pricingService.calculateTotal(articleWithQuantities);
        //Then
        double expectedTotal = (3.2 * 100) / 16;
        Assertions.assertEquals(expectedTotal, result);
    }

    @Test
    void should_return_total_for_articles_with_promos() {
        //Given
        Article article1 = new Article("article1", 100);
        Article article2 = new Article("article2", 50);


        article1.getPromos().add(bestPromoMock);
        article1.getPromos().add(goodPromoMock);
        article1.getPromos().add(mediocrePromoMock);

        article2.getPromos().add(bestPromoMock);
        article2.getPromos().add(goodPromoMock);
        article2.getPromos().add(mediocrePromoMock);

        ArticleWithQuantity articleWithQuantity1 = new ArticleWithQuantity(article1, 3);
        ArticleWithQuantity articleWithQuantity2 = new ArticleWithQuantity(article2, 2);
        Set<ArticleWithQuantity> articleWithQuantities = new HashSet<>(Arrays.asList(articleWithQuantity1, articleWithQuantity2));
        //When
        double result = pricingService.calculateTotal(articleWithQuantities);
        //Then
        Assertions.assertEquals(2, result);
    }
}
