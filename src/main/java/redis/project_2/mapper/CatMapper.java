package redis.project_2.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import redis.project_2.config.MapperConfig;
import redis.project_2.dto.CatDto;
import redis.project_2.model.Cat;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface CatMapper {
    @Mapping(target = "catPlaces", ignore = true)
    @Named("mapToCatDto")
    CatDto mapToCatDto(Cat catEntity);

    @Named("mapToCatPlacesDto")
    CatDto mapToCatPlacesDto(Cat catEntity);

    Cat mapToCatEntity(CatDto catDto);

    @Mapping(target = "catPlaces", ignore = true)
    @IterableMapping(qualifiedByName = "mapToCatDto")
    List<CatDto> mapToCatDtos(List<Cat> catEntities);

    @IterableMapping(qualifiedByName = "mapToCatPlacesDto")
    List<CatDto> mapToCatPlacesDtos(List<Cat> catEntities);

    List<Cat> mapToCatEntities(List<CatDto> catEntities);
}
