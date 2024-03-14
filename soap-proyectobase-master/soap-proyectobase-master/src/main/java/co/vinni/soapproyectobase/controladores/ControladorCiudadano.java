package co.vinni.soapproyectobase.controladores;


import co.vinni.soapproyectobase.dto.CiudadanoDto;
import co.vinni.soapproyectobase.servicios.ServicioCiudadano;
import lombok.extern.log4j.Log4j2;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class ControladorCiudadano {

    private static final Logger logger = LogManager.getLogger(ControladorCiudadano.class);

    @Autowired
    ServicioCiudadano servicioCiudadano;

    public Boolean registrarCiudadano(CiudadanoDto ciudadanodto) {
        servicioCiudadano.registrarCiudadano(ciudadanodto);
        return true;
    }

    public List<CiudadanoDto> consultarCiudadanos() {
        logger.info("Verificando ");
        return servicioCiudadano.consultarCiudadanos();
    }

}
