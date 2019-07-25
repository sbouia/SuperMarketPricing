package pricing;

import dto.ArticleWithQuantity;
import entities.Article;
import promotions.Promo;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class PricingService {

    public double calculateTotal(Set<ArticleWithQuantity> articleWithQuantities) {
        return articleWithQuantities.stream()
                .map(articleWithQuantity ->
                        priceOfBestPromo(articleWithQuantity.getArticle(), articleWithQuantity.getQuantity())
                                .orElse(articleWithQuantity.getArticle().getPrice()
                                        * articleWithQuantity.getQuantity())
                )
                .reduce(0d, (total, subTotal) -> total + subTotal);
    }

    public Optional<Double> priceOfBestPromo(Article article, double quantity) {

        if (Objects.isNull(article.getPromos()))
            return Optional.empty();

        return article.getPromos().stream().min((promo1, promo2) ->
                (int) (
                        promo1.calculate(quantity, article.getPrice())
                                - promo2.calculate(quantity, article.getPrice())
                )
        ).map(promo -> promo.calculate(quantity,article.getPrice()));
    }
}