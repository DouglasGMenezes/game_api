package com.douglasgm.gameapi.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "tb_game")
@Data
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    @Column(name = "game_year")
    private Integer year;
    private String platforms;
    private Double score;
    private String imgUrl;
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @Column(columnDefinition = "TEXT")
    private String longDescription;

    public Game(){};

    public Game(Long id, String title, String genre, Integer year, String platform, Double score, String imgUrl, String shorDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.platforms = platform;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shorDescription;
        this.longDescription = longDescription;
    }

}
