package com.artistet.service;

import com.artistet.dto.ArtistetDto;

import java.util.List;

public interface ArtistetService {

    void addArtist(ArtistetDto artistetDto);
    void modify(long id, ArtistetDto updatedArtist);
    void removeById(long id);
    ArtistetDto findById(long id);
    List<ArtistetDto> findAll();
}
