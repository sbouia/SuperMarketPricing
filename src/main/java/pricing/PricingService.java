package pricing;

import dto.ArticleWithQuantity;
import entities.Article;
import promotions.Promo;
import java.util.Optional;
import java.util.Set;

public class PricingService {

    public double calculateTotal(Set<ArticleWithQuantity> articleWithQuantities) {
        return articleWithQuantities.stream()
                .map(articleWithQuantity -> (articleWithQuantity.getQuantity() * articleWithQuantity.getArticle().getPrice()))
                .reduce(0d, (total, subTotal) -> total + subTotal);
    }

    public Optional<Promo> bestPromo(Article article) {
        return Optional.empty();
    }
}