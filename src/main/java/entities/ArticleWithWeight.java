package entities;

import lombok.Builder;
import lombok.Getter;
import promotions.Promo;

import java.util.Set;

@Getter
public class ArticleWithWeight extends Article {
    private Unity unity;

    @Builder
    public ArticleWithWeight(String name, double price, Set<Promo> promos , Unity unity) {
        super(name, price, promos);
        this.unity = unity;
    }
}
