package co.vinni.soapproyectobase.controladores;


import co.vinni.soapproyectobase.dto.NacimientosDto;
import co.vinni.soapproyectobase.entidades.Nacimientos;
import co.vinni.soapproyectobase.servicios.ServicioNacimientos;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;


@Log4j2
public class ControladorNacimientos {
    private static final Logger logger = LogManager.getLogger(ControladorNacimientos.class);

    @Autowired
    ServicioNacimientos servicioNacimientos;

    public Boolean registrarNacimientos(NacimientosDto nacimientos) {
        servicioNacimientos.registrarNacimientos(nacimientos);
        return true;
    }
    public List<NacimientosDto> consultarNacimientos(){
        logger.info("Verificando");
        return servicioNacimientos.consultarNacimientos();
    }

    /*public List<NacimientosDto> consultarNacimientosporFecha(Date fecha){
        return servicioNacimientos.consultarNacimientosPorFecha(fecha);
    }*/



}
