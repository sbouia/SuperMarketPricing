package dto;

import entities.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArticleWithQuantity {
    private Article article;
    private double quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleWithQuantity)) return false;
        ArticleWithQuantity that = (ArticleWithQuantity) o;
        return getArticle().equals(that.getArticle());
    }

    @Override
    public int hashCode() {
        return getArticle().hashCode();
    }
}
