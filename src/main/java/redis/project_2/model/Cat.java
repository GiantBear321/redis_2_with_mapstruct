package redis.project_2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;

    @Access(value = AccessType.PROPERTY)
    private String name;
    private Integer age;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cats_places",
            joinColumns = @JoinColumn(name = "cat_id"),
            inverseJoinColumns = @JoinColumn(name = "placeId")
    )
    private List<Place> catPlaces = new ArrayList<>();


    public void setName(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
