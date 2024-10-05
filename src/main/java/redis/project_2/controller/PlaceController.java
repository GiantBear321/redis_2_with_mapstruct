package redis.project_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
