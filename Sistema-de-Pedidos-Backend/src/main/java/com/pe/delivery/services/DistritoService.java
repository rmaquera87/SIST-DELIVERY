package com.pe.delivery.services;

import com.pe.delivery.repositories.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoService {

    @Autowired
    private DistritoRepository repo;

    /*public List<Cidade> findByEstado(Integer estadoId) {
        return repo.findCidades(estadoId);
    }
    */
}