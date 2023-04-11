package com.example.Loc_mns.service;

import com.example.Loc_mns.entity.Connexion;

public interface ConnexionService {
    Connexion save(Connexion connexion);
    Connexion findById(int id);
    void deleteById(int id);

    Connexion findByLogin(String login);
}

