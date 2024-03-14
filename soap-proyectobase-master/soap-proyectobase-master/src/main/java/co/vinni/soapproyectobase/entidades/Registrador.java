package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Registrador")
@Table(name = "REGISTRADORES")
public class Registrador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REGISTRADORES")
    @SequenceGenerator(name = "SEQ_REGISTADORES", sequenceName = "SEQ_REGISTRADORES", allocationSize = 1)
    @Column(name = "EQU_REGISTADOR", nullable = false)
    private String registrador;
    @Column(name = "EQU_SEDE", nullable = false)
    private String sede;

}
