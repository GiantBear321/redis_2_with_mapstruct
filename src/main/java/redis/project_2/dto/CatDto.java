package redis.project_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import redis.project_2.model.Place;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatDto implements Serializable {
    private int catId;
    private String name;
    private Integer age;
    private List<Place> catPlaces;
}
