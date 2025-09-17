package co.edu.uniandes.dse.ParcialPractico1_202520.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;
import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolar;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
@DataJpaTest
@Transactional
@Import({SistemaSolarService.class, PlanetaEntityService.class})
public class SistemaSolarPlanetaServiceTest {
    @Autowired
    private SistemaSolarPlanetaService sistemaSolarPlanetaService;
    @Autowired
    TestEntityManager entityManager;
    private PodamFactory factory= new PodamFactoryImpl();
    private List<SistemaSolar> listaSistema= new ArrayList<>();
    private List<PlanetaEntity> listaPlaneta= new ArrayList<>();
}
     