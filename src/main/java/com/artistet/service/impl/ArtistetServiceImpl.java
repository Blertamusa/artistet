package com.artistet.service.impl;

import com.artistet.dto.ArtistetDto;
import com.artistet.mappers.ArtistetMapper;
import com.artistet.repositories.ArtistetRepository;
import com.artistet.service.ArtistetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistetServiceImpl implements ArtistetService {

    private final ArtistetRepository artistetRepository;
    private final ArtistetMapper artistetMapper;

    public ArtistetServiceImpl(ArtistetRepository artistetRepository, ArtistetMapper artistetMapper) {
        this.artistetRepository = artistetRepository;

        this.artistetMapper = artistetMapper;
    }

    @Override
    public void addArtist(ArtistetDto artistetDto) {
        var entity = artistetMapper.toEntity(artistetDto);
        artistetRepository.save(entity);
    }

    @Override
    public void modify(long id, ArtistetDto updatedArtist) {
        var modifyEntity = artistetRepository.findById(id);
        if (modifyEntity.isEmpty())
            throw new RuntimeException("Artist not found");

        var entity = modifyEntity.get();
        entity.setName(updatedArtist.getName());
        entity.setEducation(updatedArtist.getEducation());
        entity.setGenres(updatedArtist.getGenres());
        entity.setBiography(updatedArtist.getBiography());
        entity.setAwards(updatedArtist.getAwards());
        entity.setPlaceOfBirth(updatedArtist.getPlaceOfBirth());

        artistetRepository.save(entity);
    }

    @Override
    public void removeById(long id) {
        artistetRepository.deleteById(id);
    }

    @Override
    public ArtistetDto findById(long id) {
        var entity = artistetRepository.findById(id);
        if (entity.isEmpty())
            throw new RuntimeException("Artist not found");
        var dto = artistetMapper.toDto(entity.get());
        return dto;
    }

    @Override
    public List<ArtistetDto> findAll() {
        return artistetRepository.findAll().stream().map(artistetMapper::toDto).toList();
    }
}
