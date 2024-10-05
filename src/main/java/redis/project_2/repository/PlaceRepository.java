package redis.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import redis.project_2.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
