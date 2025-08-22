package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.utils.GameDTOProjection;

public record GameResumeDTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {

    public GameResumeDTO(Game game) {
        this(game.getId(), game.getTitle(), game.getYear(), game.getImgUrl(), game.getShortDescription());
    }

    public GameResumeDTO(GameDTOProjection gameDTOProjection) {
        this(gameDTOProjection.getId(), gameDTOProjection.getTitle(), gameDTOProjection.getGameYear(),
             gameDTOProjection.getImgUrl(), gameDTOProjection.getShortDescription());
    }
}
