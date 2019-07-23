package pricing;

import dto.ArticleWithQuantity;
import entities.Article;
import promotions.Promo;

import java.util.Optional;
import java.util.Set;

public class PricingService {

    public double calculateTotal(Set<ArticleWithQuantity> articleWithQuantities) {
        return articleWithQuantities.stream()
                .map(articleWithQuantity ->
                        bestPromo(articleWithQuantity.getArticle(), articleWithQuantity.getQuantity())
                                .map(promo -> promo.calculate(
                                        articleWithQuantity.getArticle().getPrice(),
                                        articleWithQuantity.getQuantity()
                                        )
                                )
                                .orElse(articleWithQuantity.getArticle().getPrice() * articleWithQuantity.getQuantity())
                )
                .reduce(0d, (total, subTotal) -> total + subTotal);
    }

    public Optional<Promo> bestPromo(Article article, double quantity) {
        return article.getPromos().stream().min((promo1, promo2) ->
                (int) (promo1.calculate(quantity, article.getPrice()) -
                        promo2.calculate(quantity, article.getPrice()))
        );
    }
}