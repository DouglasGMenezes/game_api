package com.douglasgm.gameapi.repository;

import com.douglasgm.gameapi.dslist.GameMinProjection;
import com.douglasgm.gameapi.entity.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
