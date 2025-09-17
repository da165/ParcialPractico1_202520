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

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolar;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.services.SistemaSolarService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@DataJpaTest
@Transactional
@Import(SistemaSolarService.class)
public class SistemaSolarTest {
    @Autowired
    private SistemaSolarService sistemaSolarService;
    @Autowired
    private TestEntityManager entityManager;
    private PodamFactory factory= new PodamFactoryImpl();
    private List<SistemaSolar> listaSistema = new ArrayList<>();
    @BeforeEach
    void setUp(){
        clearData();
        insertData();
    }
    void clearData(){
        entityManager.getEntityManager().createQuery("delete from SistemaSolar");
    }
    void insertData(){
        for(int i=0; i<3; i++){
            SistemaSolar sistemaEntity= factory.manufacturePojo(SistemaSolar.class);
            entityManager.persist(sistemaEntity);
            listaSistema.add(sistemaEntity);
        }
    }
    @Test
    void testCrearSistema() throws IllegalOperationException, EntityNotFoundException{
        SistemaSolar newEntity =factory.manufacturePojo(SistemaSolar.class);
        SistemaSolar result= sistemaSolarService.creaSistemaSolar(newEntity);
        assertNotNull(result);

        SistemaSolar entity= entityManager.find(SistemaSolar.class, result.getId());
        assertEquals(newEntity.getId(), entity.getId());        
		assertEquals(newEntity.getNombre(), entity.getNombre());     
           
    }
}
