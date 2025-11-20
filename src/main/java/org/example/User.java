package org.example;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @Column(name="is_admin")
    private Boolean isAdmin;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Game> games = new ArrayList<Game>();

    public void addGame(Game g){
        g.setUser(this);
        this.games.add(g);
    }

}
