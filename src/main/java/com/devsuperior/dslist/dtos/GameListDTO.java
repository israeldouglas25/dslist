package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.GameList;

public record GameListDTO(Long id, String name) {

    public GameListDTO(GameList gameList) {
        this(gameList.getId(), gameList.getName());
    }
}
