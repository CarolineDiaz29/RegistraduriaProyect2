package co.vinni.soapproyectobase.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonaDto implements Serializable {
    private int documento;
    private String tipoDocumentoDto;
    private String primerApellido;
    private String segundoApellido;
    private String nombres;
    private Date fechadeNacimiento;
    private String lugardeNacimiento;
    private String sexo;
    private String rh;


}
