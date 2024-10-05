package redis.project_2.mapper;

import org.mapstruct.Mapper;
import redis.project_2.config.MapperConfig;
import redis.project_2.dto.CatDto;
import redis.project_2.model.Cat;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface CatMapper {
    CatDto mapToCatDto(Cat catEntity);

    Cat mapToCatEntity(CatDto catDto);

    List<CatDto> mapToCatDtos(List<Cat> catEntities);

    List<Cat> mapToCatEntities(List<CatDto> catEntities);
}
