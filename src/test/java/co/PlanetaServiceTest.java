package co;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.services.PlanetaEntityService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@DataJpaTest
@Transactional
@Import(PlanetaEntityService.class)
public class PlanetaServiceTest {
    @Autowired
    private PlanetaEntityService planetaEntityService;
    @Autowired
    TestEntityManager entityManager;
        private PodamFactory factory= new PodamFactoryImpl();
    private List<PlanetaEntity> listaSistema = new ArrayList<>();
    @BeforeEach
    void setUp(){
        clearData();
        insertData();
    }
    void clearData(){
        entityManager.getEntityManager().createQuery("delete from PlanetaEntity");
    }
    void insertData(){
        for(int i=0; i<3; i++){
            PlanetaEntity sistemaEntity= factory.manufacturePojo(PlanetaEntity.class);
            entityManager.persist(sistemaEntity);
            listaSistema.add(sistemaEntity);
        }
    }
    @Test
    void testCrearSistema() throws IllegalOperationException, EntityNotFoundException{
        PlanetaEntity newEntity =factory.manufacturePojo(PlanetaEntity.class);
        PlanetaEntity result= planetaEntityService.crearPlaneta(newEntity);
        assertNotNull(result);

        PlanetaEntity entity= entityManager.find(PlanetaEntity.class, result.getId());
        assertEquals(newEntity.getId(), entity.getId());        
		assertEquals(newEntity.getNombre(), entity.getNombre());        
    }
}
