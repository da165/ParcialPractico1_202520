package co.edu.uniandes.dse.ParcialPractico1_202520.repositories;
import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface PlanetaEntityRepository extends JpaRepository<PlanetaEntity, Long>{
    List<PlanetaEntity> findByNombre(String nombre);
    List<PlanetaEntity> findByPoblacion(Integer poblacion);
}
