package co.vinni.soapproyectobase.controladores;


import co.vinni.soapproyectobase.dto.RegistradorDto;
import co.vinni.soapproyectobase.entidades.Registrador;
import co.vinni.soapproyectobase.servicios.ServicioRegistrador;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Log4j2
public class ControladorRegistrador {

    private static final Logger logger = LogManager.getLogger(ControladorRegistrador.class);

    @Autowired
    ServicioRegistrador servicioRegistrador;

    public boolean registrarRegistrador(RegistradorDto registrador) {
        servicioRegistrador.registrarRegistrador(registrador);
        return true;
    }

    public List<Registrador> consultarRegistradores(){
        logger.info("Verificando");
        return servicioRegistrador.consultarRegistradores();
    }

}
