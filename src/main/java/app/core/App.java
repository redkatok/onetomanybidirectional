package app.core;

import app.core.model.Cart;
import app.core.model.Item;
import app.core.repository.CartRepo;
import app.core.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class App implements CommandLineRunner {


    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ItemRepo itemRepo;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        //TODO - при сохранении через владельца внешних ключей  т е owner - данные сохранятся с внешними ключами,
        // при сохранении через inverse end - только данные - внешние ключи будьут пустые
//        Cart cart = new Cart("CartOne", Arrays.asList(new Item("item1"),
//                new Item("item2"), new Item("item3")));
//        cartRepo.save(cart);

        Item item=new Item("item4");
        Cart cart2=new Cart("cartTwo");
        item.setCart(cart2);
        itemRepo.save(item);
    }
}
