package com.artistet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistetDto {
    private long id;
    private String name;
    private String education;
    private String biography;
    private String genres;
    private String placeOfBirth;
    private String awards;
}
