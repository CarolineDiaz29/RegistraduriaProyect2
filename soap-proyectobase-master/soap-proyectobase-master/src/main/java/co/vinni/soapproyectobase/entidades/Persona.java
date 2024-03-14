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
@Entity(name = "Persona")
@Table(name = "PERSONAS")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSONAS")
    @SequenceGenerator(name = "SEQ_PERSONAS", sequenceName = "SEQ_PERSONAS", allocationSize = 1)
    @Column(name = "EQU_DOCUMENTO", nullable = false)
    private int documento;
    @Column(name = "EQU_TIPODOCUMENTO",nullable = false)
    private String tipoDocumento;
    @Column(name = "EQU_PRIMERAPELLIDO", nullable = false)
    private String primerApellido;
    @Column(name = "EQU_SEGUNDOAPELLIDO", nullable = false)
    private String segundoApellido;
    @Column(name = "EQU_NOMBRES", nullable = false)
    private String nombres;
    @Column(name = "EQU_FechaDeNacimiento", nullable = false)
    private Date fechadeNacimiento;
    @Column(name = "EQU_LUGARDENACIMIENTO", nullable = false)
    private String lugardeNacimiento;
    @Column(name = "EQU_SEXO", nullable = false)
    private String sexo;
    @Column(name = "EQU_RH", nullable = false)
    private String rh;
}

