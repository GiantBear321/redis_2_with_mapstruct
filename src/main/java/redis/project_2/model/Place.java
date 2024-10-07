package redis.project_2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "places")
public class Place implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeId;

    @Column(unique = true)
    private String name;

    private String address;

    public Place(int placeId) {
        this.placeId = placeId;
    }

    public Place() {}
}
