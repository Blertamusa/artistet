package com.artistet.mappers;

import com.artistet.dto.ArtistetDto;
import com.artistet.model.Artistet;
import org.springframework.stereotype.Component;

@Component
public class ArtistetMapper {
    public Artistet toEntity(ArtistetDto dto) {
        var entity = new Artistet();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEducation(dto.getEducation());
        entity.setGenres(dto.getGenres());
        entity.setAwards(dto.getAwards());
        entity.setBiography(dto.getBiography());
        entity.setPlaceOfBirth(dto.getPlaceOfBirth());
        return entity;
    }
    public ArtistetDto toDto(Artistet entity) {
        var dto = new ArtistetDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEducation(entity.getEducation());
        dto.setGenres(entity.getGenres());
        dto.setAwards(entity.getAwards());
        dto.setBiography(entity.getBiography());
        dto.setPlaceOfBirth(entity.getPlaceOfBirth());
        return dto;
    }
}
