package dev.games.IfGames.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_Category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;

    @OneToMany(mappedBy = "category")
    private List<GamesModel> games;

}
