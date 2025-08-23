package com.douglasgm.gameapi.repository;

import com.douglasgm.gameapi.entity.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
