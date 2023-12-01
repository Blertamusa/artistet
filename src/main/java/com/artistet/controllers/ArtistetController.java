package com.artistet.controllers;


import com.artistet.dto.ArtistetDto;
import com.artistet.service.ArtistetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistet/")
@CrossOrigin
public class ArtistetController {
    private final ArtistetService artistetService;

    public ArtistetController(ArtistetService artistetService) {
        this.artistetService = artistetService;
    }

    @GetMapping
    public List<ArtistetDto> getAllArtistet() {
        return artistetService.findAll();
    }

    @GetMapping("/{id}")
    public ArtistetDto getById(@PathVariable long id) {
        return artistetService.findById(id);
    }

    @PostMapping
    public void addArtist(@RequestBody ArtistetDto newArtist) {
        artistetService.addArtist(newArtist);
    }

    @PutMapping("/{id}")
    public void updateArtistet(@PathVariable long id, @RequestBody ArtistetDto updatedArtistet) {
        artistetService.modify(id, updatedArtistet);
    }

    @DeleteMapping("/{id}")
    public void deleteArtistet(@PathVariable long id) {
        artistetService.removeById(id);
    }
}
