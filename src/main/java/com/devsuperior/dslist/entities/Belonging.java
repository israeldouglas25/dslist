package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_belonging")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Belonging {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging(Game game, GameList gameList, Integer position) {
        this.id = new BelongingPK();
        this.id.setGame(game);
        this.id.setGameList(gameList);
        this.position = position;
    }

}
