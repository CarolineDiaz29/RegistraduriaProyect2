package co.vinni.soapproyectobase.dto;

import co.vinni.soapproyectobase.entidades.Persona;
import co.vinni.soapproyectobase.entidades.Registrador;
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
public class NacimientosDto implements Serializable {
    private int id;
    private Date fecha;
    private String persona;
    private String registrador;

}
