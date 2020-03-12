package fr.ugesellsloaning.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Media {
/*
    public Media(Long i, String file, String path){
        this.id = i;
        this.filename = file;
        this.path = path;
    }
   */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String filename;

    @Column(length = 500)
    String path;

}
