package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import promotions.Promo;

import java.util.Set;

@Getter
@AllArgsConstructor
public class Article {
    private String name;
    private double price;
    private Set<Promo> promos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;

        Article article = (Article) o;

        return getName().equals(article.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
