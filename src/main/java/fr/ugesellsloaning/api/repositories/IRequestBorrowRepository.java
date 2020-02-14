package fr.ugesellsloaning.api.repositories;

import fr.ugesellsloaning.api.entities.RequestBorrow;
import fr.ugesellsloaning.api.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRequestBorrowRepository extends CrudRepository<RequestBorrow, Long> {
   
}
