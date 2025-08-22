package com.douglasgm.gameapi.dto;

import com.douglasgm.gameapi.dslist.GameMinProjection;
import com.douglasgm.gameapi.entity.Game;

public record GameMinDTO(Long id,
                         String title,
                         Integer year,
                         String imgUrl,
                         String shortDescription
) {


    public GameMinDTO(Game game) {
        this(game.getId(),
             game.getTitle(),
             game.getYear(),
             game.getImgUrl(),
             game.getShortDescription()
        );
    }

    public GameMinDTO(GameMinProjection projection) {
        this(projection.getId(),
                projection.getTitle(),
                projection.getGameYear(),
                projection.getImgUrl(),
                projection.getShortDescription()
        );
    }


}
