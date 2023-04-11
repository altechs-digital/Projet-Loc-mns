package com.example.Loc_mns.entity;

import javax.persistence.*;

@Entity
@Table(name = "connexion")
public class Connexion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login", nullable = false, length = 20)
    private String login;



    @Column(nullable = false, length = 64)
    private String password;


    @Column(name = "profil", nullable = false, length = 20)
    private boolean profil;

    //constructeurs, getters, setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getProfil() {
        return profil;
    }

    public void setProfil(boolean profil) {
        this.profil = profil;
    }
}
