import dto.ArticleWithQuantity;
import entities.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pricing.PricingService;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class PricingTest {

    public static PricingService pricingService = new PricingService();

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
}
