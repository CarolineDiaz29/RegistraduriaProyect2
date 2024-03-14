package co.vinni.soapproyectobase.controladores;
import co.vinni.soapproyectobase.dto.PersonaDto;
import co.vinni.soapproyectobase.dto.TipoIdentidadDto;
import lombok.extern.log4j.Log4j2;
import co.vinni.soapproyectobase.entidades.Persona;
import co.vinni.soapproyectobase.entidades.TipoIdentidad;
import co.vinni.soapproyectobase.servicios.ServicioPersona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Log4j2
public class ControladorPersona {

    private static final Logger logger = LogManager.getLogger(ControladorPersona.class);

    @Autowired
    ServicioPersona servicioPersona;

    public boolean registrarPersona(PersonaDto persona) {
        servicioPersona.registrarPersona(persona);
        return true;
    }
    public List<PersonaDto> consultarPersonas() {
        logger.info("Verificando");
        return servicioPersona.consultarPersonas();
    }

    public Boolean modificarTipoIdentidadPersona(String nuevoTipoIdentidad, PersonaDto personaDto) {
        personaDto.setTipoDocumentoDto(nuevoTipoIdentidad);
        servicioPersona.modificarpersona(personaDto);
        return true;

    }

}
