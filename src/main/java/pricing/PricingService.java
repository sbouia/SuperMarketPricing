package pricing;

import dto.ArticleWithQuantity;

import java.util.Set;

public class PricingService {

    public double calculateTotal(Set<ArticleWithQuantity> articleWithQuantities) {
        return articleWithQuantities.stream()
                .map(articleWithQuantity -> (articleWithQuantity.getQuantity() * articleWithQuantity.getArticle().getPrice()))
                .reduce(0d, (total, subTotal) -> total + subTotal);
    }
}