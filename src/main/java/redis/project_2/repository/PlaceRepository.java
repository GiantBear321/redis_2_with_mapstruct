package redis.project_2.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import redis.project_2.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    @Modifying
    @Query(value = "DELETE FROM building.cats_places cp WHERE cp.place_id = :placeId", nativeQuery = true)
    void removePlaceFromCatsPlaces(@Param("placeId") Integer placeId);
}
