package dev.games.IfGames.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_Category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;

}
