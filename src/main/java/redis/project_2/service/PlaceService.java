package redis.project_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.project_2.model.Place;
import redis.project_2.repository.CatRepository;
import redis.project_2.repository.PlaceRepository;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private CatRepository catRepository;

    public int save(Place place) {
        return placeRepository.save(place).getPlaceId();
    }

    public List<Place> findAll() {
        return placeRepository.findAll();
    }


    @Transactional
    @CacheEvict(value = "catPlaces", allEntries = true)
    public void deletePlace(Integer id) {
        placeRepository.removePlaceFromCatsPlaces(id);

        placeRepository.deleteById(id);
    }
}
