package com.douglasgm.gameapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.java.Log;

@Entity
@Table(name = "tb_game_list")
@Data
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public GameList(){};

    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
