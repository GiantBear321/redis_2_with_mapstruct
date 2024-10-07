package redis.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import redis.project_2.model.Cat;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

    @Query(value = "FROM Cat c LEFT JOIN FETCH c.catPlaces")
    List<Cat> findAllCatPlaces();

    @Query(value = "FROM Cat c LEFT JOIN FETCH c.catPlaces WHERE c.catId=:id")
    Optional<Cat> findCatById(@Param("id") Integer id);

    @Query(value = "FROM Cat c LEFT JOIN FETCH c.catPlaces WHERE placeId=:id")
    List<Cat> findAllCatPlacesByPlaceId(@Param("id") Integer id);
}
