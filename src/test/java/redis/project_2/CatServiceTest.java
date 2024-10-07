package redis.project_2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import redis.project_2.model.Cat;
import redis.project_2.repository.CatRepository;
import redis.project_2.service.CatService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CatServiceTest {
    @Autowired
    private CatService catService;

    @Autowired
    private CatRepository catRepository;

    @Test
    @Transactional
    public void testDeleteCat() {
        Cat cat = new Cat();
        cat.setName("Tom");
        cat.setAge(5);
        int savedId = catService.save(cat);

        assertNotNull(catService.findById(savedId));

        catService.deleteCat(savedId);

        assertThrows(RuntimeException.class, () -> catService.findById(savedId));
    }
}