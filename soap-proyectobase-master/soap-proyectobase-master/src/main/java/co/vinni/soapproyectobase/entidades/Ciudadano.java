package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Ciudadano")
@Table(name = "Ciudadanos")
public class Ciudadano implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CIUDADANOS")
    @SequenceGenerator(name = "SEQ_CIUDADANOS", sequenceName = "SEQ_CIUDADANOS", allocationSize = 1)
    @Column(name = "EQU_NACIDO", nullable = false)
    private String nacido;

    @Column(name = "EQU_MAMA", nullable = false)
    private String mama;

    @Column(name = "EQU_PAPA", nullable = false)
    private String papa;


}
