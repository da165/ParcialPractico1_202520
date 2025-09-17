package co.edu.uniandes.dse.ParcialPractico1_202520.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolar;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.SistemaSolarRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SistemaSolarService {
    @Autowired
    private SistemaSolarRepository sistemaSolarRepository;
    @Transactional
    public SistemaSolar creaSistemaSolar(SistemaSolar sistemaSolar) throws IllegalOperationException, EntityNotFoundException{
        log.info("inicia el proceso de creacion de un sistema solar");
        if(sistemaSolar.getNombre().length()<3){
            throw new IllegalOperationException("El nombre no es valido");
        }
        if(sistemaSolar.getRatioFuerza()>0.6){
            throw new IllegalOperationException("el ratio de fuerza excede los limites");
        }
        if(sistemaSolar.getRatioFuerza()<0.2){
            throw new IllegalOperationException("El ratio es muy bajo");
        }
        if(sistemaSolar.getNumeroSoldados()<1000){
            throw new IllegalOperationException("El numero de soldados es insuficiente");
        }
        log.info("Termina el proceso de crear sitema solar");
        return sistemaSolarRepository.save(sistemaSolar);
    }
    
}
