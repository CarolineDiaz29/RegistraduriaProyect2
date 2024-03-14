package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.NacimientosDto;
import co.vinni.soapproyectobase.entidades.Nacimientos;
import co.vinni.soapproyectobase.repositorios.RespositorionNacimientos;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicioNacimientos implements Serializable {
    private ModelMapper modelMapper;

    @Autowired
    RespositorionNacimientos repoNaci;

    public void registrarNacimientos(NacimientosDto nacimientosDto) {
        repoNaci.save(modelMapper.map(nacimientosDto, Nacimientos.class));
    }

    public List<NacimientosDto> consultarNacimientos() {
        TypeToken<List<NacimientosDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoNaci.findAll(), typeToken.getType());
    }

    /*public List<NacimientosDto> consultarNacimientosPorFecha(Date fecha) {
        List<Nacimientos> nacimientosPorFecha = repoNaci.findByFecha(fecha);
        TypeToken<List<NacimientosDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(nacimientosPorFecha, typeToken.getType());
    }*/

}
