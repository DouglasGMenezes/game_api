package com.douglasgm.gameapi.api;

import com.douglasgm.gameapi.dto.GameListDTO;
import com.douglasgm.gameapi.dto.GameMinDTO;
import com.douglasgm.gameapi.service.GameService;
import com.douglasgm.gameapi.service.GamelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GamelistService gamelistService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> lists() {
        return gamelistService.findAll();
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByLists(listId);
    }
}
