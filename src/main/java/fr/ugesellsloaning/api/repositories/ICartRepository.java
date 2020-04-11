package fr.ugesellsloaning.api.repositories;

import com.fasterxml.jackson.annotation.JsonRawValue;
import fr.ugesellsloaning.api.entities.Borrow;
import fr.ugesellsloaning.api.entities.Cart;
import fr.ugesellsloaning.api.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICartRepository extends CrudRepository<Cart, Long> {

    List<Cart> findCartByUser(long user);
    Cart  findCartByProduct(long product);


}
