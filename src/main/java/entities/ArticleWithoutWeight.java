package entities;


import lombok.Builder;
import promotions.Promo;

import java.util.Set;

public class ArticleWithoutWeight extends Article {
    @Builder
    public ArticleWithoutWeight(String name, double price, Set<Promo> promos) {
        super(name, price, promos);
    }
}
