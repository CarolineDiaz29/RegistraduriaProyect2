package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TipoIdentidad")
@Table(name = "TIPOIDENTIDAD")
public class TipoIdentidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPOIDENTIDAD")
    @SequenceGenerator(name = "SEQ_TIPOIDENTIDAD", sequenceName = "SEQ_TIPOIDENTIDAD", allocationSize = 1)
    @Column(name = "EQU_TIPOIDENTIDAD", nullable = false)
    private String tipoDocumento;

}
