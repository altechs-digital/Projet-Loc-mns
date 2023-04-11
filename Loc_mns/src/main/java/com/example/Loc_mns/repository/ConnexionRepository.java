package com.example.Loc_mns.repository;

import com.example.Loc_mns.entity.Connexion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnexionRepository extends JpaRepository<Connexion, Integer> {
    Connexion findByLogin(String login);
}

