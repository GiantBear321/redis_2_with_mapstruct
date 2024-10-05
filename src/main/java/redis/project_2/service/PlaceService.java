package redis.project_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.project_2.model.Place;
import redis.project_2.repository.PlaceRepository;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public int save(Place place) {
        return placeRepository.save(place).getPlaceId();
    }

    public List<Place> findAll() {
        return placeRepository.findAll();
    }
}
