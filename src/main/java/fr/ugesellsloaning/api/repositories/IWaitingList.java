package fr.ugesellsloaning.api.repositories;

import fr.ugesellsloaning.api.entities.Comment;
import fr.ugesellsloaning.api.entities.Product;
import fr.ugesellsloaning.api.entities.User;
import fr.ugesellsloaning.api.entities.WaitingList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IWaitingList extends CrudRepository<WaitingList, Long> {

    WaitingList findWaitingListByProduct(long product);
    //User UserPioritaire (WaitingList waitingList);
}
