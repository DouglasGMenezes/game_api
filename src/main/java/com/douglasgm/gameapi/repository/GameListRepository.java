package com.douglasgm.gameapi.repository;

import com.douglasgm.gameapi.entity.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameListRepository extends JpaRepository<GameList, Long> {

//    @Modifying
//    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE game_list_id = :listId AND game_id = :gameId")
//    void updateBelongingPosition(Long gameListId, Long gameId, Integer newPosition);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging " +
            "SET position = :newPosition " +
            "WHERE game_list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(
            @Param("listId") Long listId,
            @Param("gameId") Long gameId,
            @Param("newPosition") Integer newPosition
    );

}
