package com.example.summer_school_hw.model.data.dto

import com.example.summer_school_hw.model.data.room.entities.Movie

data class MovieDto(
    val title: String,
    val description: String,
    val rateScore: Int,
    val ageRestriction: Int,
    val imageUrl: String,
    val posterUrl: String,
    val genre: List<GenreDto>,
    val actors: List<ActorDto>
)