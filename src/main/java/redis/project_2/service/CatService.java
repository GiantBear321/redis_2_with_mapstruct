package redis.project_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.project_2.dto.CatDto;
import redis.project_2.mapper.CatMapper;
import redis.project_2.model.Cat;
import redis.project_2.model.Place;
import redis.project_2.repository.CatRepository;
import redis.project_2.repository.PlaceRepository;

import java.util.List;

@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CatMapper catMapper;

    public int save(Cat cat) {
        return catRepository.save(cat).getCatId();
    }

    @Cacheable(value="cat")
    public List<CatDto> findAll() {
        return catMapper.mapToCatDtos(catRepository.findAll());
    }

    public Cat setCatsPlaces(Integer catId, List<Integer> placesIds) {
        Cat cat = catRepository.findById(catId).orElseThrow(() -> new RuntimeException("Cat not found"));
        List<Place> allPlacesById = placeRepository.findAllById(placesIds);

        cat.setCatPlaces(allPlacesById);

        return catRepository.save(cat);
    }
}
