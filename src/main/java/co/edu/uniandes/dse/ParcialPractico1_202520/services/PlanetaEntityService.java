package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.PlanetaEntityRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlanetaEntityService {
    @Autowired
    private PlanetaEntityRepository planetaEntityRepository;
    @Transactional
    public PlanetaEntity crearPlaneta(PlanetaEntity planeta) throws IllegalOperationException{
        log.info("Inicia el proceso de crear un planeta");
        if(planeta.getNombre().valueOf(-1)!="I"){
            throw new IllegalOperationException("El sufijo del planeta es invalido");
        }
        if(planeta.getPoblacion()<0){
            throw new IllegalOperationException("La poblacion no es valida");
        }
        return planetaEntityRepository.save(planeta);
    }
    
}
