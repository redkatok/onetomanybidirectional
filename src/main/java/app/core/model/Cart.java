package app.core.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue
    private Long id;


    private String name;


    @OneToMany(
            //все операции совершенные над  Cart  - применятся и к связанным с ним обьектам Item
            cascade = CascadeType.ALL,
            //mappedBy- указывает на поле которое является owner отношений
            mappedBy = "cart",
            orphanRemoval = true)
    private List<Item> itemList = new ArrayList<>();

    public Cart(String name, List<Item> itemList) {
        this.name = name;
        this.itemList = itemList;
    }

    public Cart(String name) {
        this.name = name;
    }
}
