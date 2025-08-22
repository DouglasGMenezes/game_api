package com.douglasgm.gameapi.api;

import com.douglasgm.gameapi.dto.GameDTO;
import com.douglasgm.gameapi.dto.GameListDTO;
import com.douglasgm.gameapi.dto.GameMinDTO;
import com.douglasgm.gameapi.entity.Game;
import com.douglasgm.gameapi.service.GameService;
import com.douglasgm.gameapi.service.GamelistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameMinDTO> list() {
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO byId(@PathVariable Long id) {
        return gameService.findById(id);
    }


}
