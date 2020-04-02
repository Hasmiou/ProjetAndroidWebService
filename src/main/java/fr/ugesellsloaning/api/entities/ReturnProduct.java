package fr.ugesellsloaning.api.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
public class ReturnProduct {

    public ReturnProduct(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        returnAt = dateFormat.format(d).toString();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String returnAt;
    long product;

    String state;

}
