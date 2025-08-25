package com.douglasgm.gameapi.service;

import com.douglasgm.gameapi.dslist.GameMinProjection;
import com.douglasgm.gameapi.dto.GameListDTO;
import com.douglasgm.gameapi.entity.GameList;
import com.douglasgm.gameapi.repository.GameListRepository;
import com.douglasgm.gameapi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GamelistService {

    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gamesList = gameListRepository.findAll();
        return gamesList.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId , int sourceIndex, int destinationIndex ) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
         GameMinProjection obj = list.remove(sourceIndex);
         list.add(destinationIndex, obj);

         int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
         int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

         for (int i = min; i <= max; i++) {
             gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
         };
    }

}
