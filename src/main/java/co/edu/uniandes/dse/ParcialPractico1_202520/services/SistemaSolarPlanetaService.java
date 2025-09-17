package co.edu.uniandes.dse.ParcialPractico1_202520.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.PlanetaEntityRepository;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.SistemaSolarRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import co.edu.uniandes.dse.ParcialPractico1_202520.entities.*;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;


@Slf4j
@Service
public class SistemaSolarPlanetaService {
    @Autowired
    private SistemaSolarRepository sistemaSolarRepository;
    @Autowired
    private PlanetaEntityRepository planetaEntityRepository;
    @Transactional
    public PlanetaEntity addPlanetaDeSistemaSolar(Long idPlaneta, Long idSistema) throws IllegalOperationException{
        log.info("Inicia el proceso de añadir un planeta a un sistema solar");
        Optional<PlanetaEntity> planetaEntityOpt= planetaEntityRepository.findById(idPlaneta);
        Optional<SistemaSolar> sistemaSolarOpt= sistemaSolarRepository.findById(idSistema);
        if((sistemaSolarOpt.get().getRatioFuerza()/planetaEntityOpt.get().getDiametroPlaneta())<Double.valueOf(planetaEntityOpt.get().getPoblacion())){
            throw new IllegalOperationException("Los ratios son incompatibles");
        }
        PlanetaEntity planeta= planetaEntityOpt.get();
        SistemaSolar sistema=sistemaSolarOpt.get();
        if(!sistema.getPlanetas().contains(planeta)){
            sistema.getPlanetas().add(planeta);
        }
        log.info("Termina el proceso de añadir un planeta a un sistema");
        return planeta;
    }
}
