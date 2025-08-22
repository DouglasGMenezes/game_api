package com.douglasgm.gameapi.service;

import com.douglasgm.gameapi.dslist.GameMinProjection;
import com.douglasgm.gameapi.dto.GameDTO;
import com.douglasgm.gameapi.dto.GameMinDTO;
import com.douglasgm.gameapi.entity.Game;
import com.douglasgm.gameapi.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> gamesList = gameRepository.findAll();
        return gamesList.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game game = gameRepository.findById(id).get();
        GameDTO resultGameDTO = new GameDTO(game);
        return resultGameDTO;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByLists(Long listId){
        List<GameMinProjection> gamesList = gameRepository.searchByList(listId);
        return gamesList.stream().map(GameMinDTO::new).toList();
    }

}
