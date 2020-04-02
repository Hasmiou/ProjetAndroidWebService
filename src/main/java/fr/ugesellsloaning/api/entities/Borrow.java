package fr.ugesellsloaning.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Borrow implements Serializable {
    public Borrow(){
        returned = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String startAt;

    String endAt;

    boolean returned;

    long product;

    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @OneToOne(fetch = FetchType.LAZY)
    ReturnProduct returnProduct;
}
