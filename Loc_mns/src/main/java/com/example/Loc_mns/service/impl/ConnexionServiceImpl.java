package com.example.Loc_mns.service.impl;

import com.example.Loc_mns.entity.Connexion;
import com.example.Loc_mns.repository.ConnexionRepository;
import com.example.Loc_mns.service.ConnexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnexionServiceImpl implements ConnexionService {

    @Autowired
    private ConnexionRepository connexionRepository;

    @Override
    public Connexion save(Connexion connexion) {
        return connexionRepository.save(connexion);
    }


    @Override
    public Connexion findById(int id) {
        return connexionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        connexionRepository.deleteById(id);
    }

    @Override
    public Connexion findByLogin(String login) {
        return connexionRepository.findByLogin(login);
    }
}

