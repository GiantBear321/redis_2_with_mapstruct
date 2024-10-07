package redis.project_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.project_2.dto.CatDto;
import redis.project_2.model.Cat;
import redis.project_2.service.CatService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cats")
public class CatController {
    @Autowired
    private CatService service;

    @PostMapping
    public ResponseEntity<String> saveCat(@RequestBody Cat cat) {
        int savedCatId = service.save(cat);
        return new ResponseEntity<>("New cat`s id is: " + savedCatId, HttpStatusCode.valueOf(201));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CatDto>> getAllCats() {
        return new ResponseEntity<>(service.findAll(), HttpStatusCode.valueOf(200));
    }

    @GetMapping(value = "/{catId}")
    public ResponseEntity<CatDto> findById(@PathVariable Integer catId) {
        return new ResponseEntity<>(service.findById(catId), HttpStatusCode.valueOf(200));
    }

    @GetMapping(value = "/all/places")
    public ResponseEntity<List<CatDto>> getAllCatsPlaces() {
        return new ResponseEntity<>(service.findAllCatPlaces(), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/places/{catId}")
    public ResponseEntity<Cat> saveCat(@PathVariable Integer catId, @RequestBody List<Integer> placesIds) {
        Cat savedCat = service.setCatsPlaces(catId, placesIds);
        return new ResponseEntity<>(savedCat, HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/{catId}")
    public String deleteCat(@PathVariable Integer catId) {
        service.deleteCat(catId);
        return "cat was deleted";
    }
}
