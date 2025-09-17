package co.edu.uniandes.dse.ParcialPractico1_202520.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
@Data
public class SistemaSolar extends BaseEntity {
    private String nombre;
    private Float ratioFuerza;
    private Float numeroSoldados;
    private RegionType regionGalaxia;
    @OneToMany(mappedBy = "sistema solar")
    @PodamExclude
    private List<PlanetaEntity> planetas= new ArrayList<>();
}
