package fr.ugesellsloaning.api.repositories;

import fr.ugesellsloaning.api.entities.Comment;
import fr.ugesellsloaning.api.entities.Notification;
import fr.ugesellsloaning.api.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface INotificationRepository extends CrudRepository<Notification, Long> {
    List<Notification> findNotificationByUser(long user);
}
