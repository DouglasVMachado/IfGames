package dev.games.IfGames.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Games")
public class GamesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int lançamento;
    private String name;
    private Long preco;

    public GamesModel() {
    }

    public GamesModel(Long id, String name, int lançamento, Long preco) {
        this.id = id;
        this.name = name;
        this.lançamento = lançamento;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLançamento() {
        return lançamento;
    }

    public void setLançamento(int lançamento) {
        this.lançamento = lançamento;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }
}
