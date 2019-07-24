import dto.ArticleWithQuantity;
import entities.ArticleWithWeight;
import entities.ArticleWithoutWeight;
import entities.Unity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pricing.PricingService;
import promotions.Promo;
import promotions.PromoBuyTwoGetOneFree;
import promotions.PromoThreeForDollar;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class PricingTest {

    private static PricingService pricingService = new PricingService();
    private static Promo promoThreeForDollar = new PromoThreeForDollar();
    private static Promo promoBuyTwoGetOneFree = new PromoBuyTwoGetOneFree();

    @Test
    void test() {
        Assertions.assertTrue(true);
    }

    @Test
    void should_calculate_total_amount_of_bought_articles() {
        //Given
        ArticleWithoutWeight article1 = ArticleWithoutWeight.builder().name("article1").price(100).build();
        ArticleWithoutWeight article2 = ArticleWithoutWeight.builder().name("article2").price(50).build();
        ArticleWithQuantity articleWithQuantity1 = ArticleWithQuantity.builder().article(article1).quantity(3).build();
        ArticleWithQuantity articleWithQuantity2 = ArticleWithQuantity.builder().article(article2).quantity(2).build();
        Set<ArticleWithQuantity> articleWithQuantities = new HashSet<>(Arrays.asList(articleWithQuantity1, articleWithQuantity2));
        //When
        double result = pricingService.calculateTotal(articleWithQuantities);
        //Then
        Assertions.assertEquals(400, result);

    }

    @Test
    void should_calculate_total_amount_of_bought_weighted_articles() {
        //Given
        ArticleWithoutWeight article1 = ArticleWithoutWeight.builder().name("article1").price(100.00).build();
        ArticleWithoutWeight article2 = ArticleWithoutWeight.builder().name("article1").price(50.00).build();
        ArticleWithQuantity articleWithQuantity1 = ArticleWithQuantity.builder().article(article1).quantity(3.2).build();
        ArticleWithQuantity articleWithQuantity2 = ArticleWithQuantity.builder().article(article2).quantity(2.5).build();
        Set<ArticleWithQuantity> articleWithQuantities = new HashSet<>(Arrays.asList(articleWithQuantity1, articleWithQuantity2));
        //When
        double result = pricingService.calculateTotal(articleWithQuantities);
        //Then
        Assertions.assertEquals(445d, result);
    }

    @Test
    void should_calculate_total_amount_of_bought_weighted_articles_in_ounces() {
        //Given
        ArticleWithWeight article = ArticleWithWeight.builder().name("article1").price(100).unity(Unity.POUND).build();
        double quantityInOunce = 3.2;
        ArticleWithQuantity articleWithQuantity = ArticleWithQuantity.builder().article(article).quantity(Unity.OUNCE.convertToPound(quantityInOunce)).build();
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
        ArticleWithoutWeight article1 = ArticleWithoutWeight.builder().name("article1").price(100).promos(new HashSet<>(Arrays.asList(promoThreeForDollar,promoBuyTwoGetOneFree))).build();
        ArticleWithoutWeight article2 = ArticleWithoutWeight.builder().name("article2").price(50).promos(new HashSet<>(Arrays.asList(promoThreeForDollar,promoBuyTwoGetOneFree))).build();
        ArticleWithQuantity articleWithQuantity1 =  ArticleWithQuantity.builder().article(article1).quantity(3).build();
        ArticleWithQuantity articleWithQuantity2 = ArticleWithQuantity.builder().article(article2).quantity(2).build();
        Set<ArticleWithQuantity> articleWithQuantities = new HashSet<>(Arrays.asList(articleWithQuantity1, articleWithQuantity2));
        //When
        double result = pricingService.calculateTotal(articleWithQuantities);
        //Then
        Assertions.assertEquals(101, result);
    }
}
