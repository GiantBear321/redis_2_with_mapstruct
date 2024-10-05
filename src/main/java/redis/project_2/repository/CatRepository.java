package redis.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import redis.project_2.model.Cat;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

    @Query(value = "FROM Cat c LEFT JOIN FETCH c.catPlaces")
    List<Cat> findAll();
}
