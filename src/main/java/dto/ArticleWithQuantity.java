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

}
