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
@Entity(name = "Nacimiento")
@Table(name = "NACIMIENTOS")
public class Nacimientos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NACIMIENTOS")
    @SequenceGenerator(name = "SEQ_NACIMIENTOS", sequenceName = "SEQ_NACIMIENTOS", allocationSize = 1)
    @Column(name = "EQU_ID", nullable = false)
    private int id;
    @Column(name = "EQU_FECHA", nullable = false)
    private Date fecha;
    @Column(name = "EQU_PERSONA", nullable = false)
    private String persona;
    @Column(name = "EQU_REGISTRADOR", nullable = false)
    private String registrador;

}
