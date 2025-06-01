package dev.games.IfGames.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Games")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GamesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int lançamento;
    private String name;
    private Long preco;
    private String imgUrl;
    private String dificuldade;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    }

