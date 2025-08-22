package com.douglasgm.gameapi.service;

import com.douglasgm.gameapi.dto.GameListDTO;
import com.douglasgm.gameapi.dto.GameMinDTO;
import com.douglasgm.gameapi.entity.Game;
import com.douglasgm.gameapi.entity.GameList;
import com.douglasgm.gameapi.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GamelistService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gamesList = gameListRepository.findAll();
        return gamesList.stream().map(GameListDTO::new).toList();
    }

}
