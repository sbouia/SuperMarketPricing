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
}
