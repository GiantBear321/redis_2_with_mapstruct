package redis.project_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.project_2.model.Place;
import redis.project_2.service.PlaceService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping(value = "/all")
    public List<Place> findAllPlaces() {
        return placeService.findAll();
    }

    @DeleteMapping("/{placeId}")
    public void deletePlace(@PathVariable Integer placeId) {
       placeService.deletePlace(placeId);
    }
}
