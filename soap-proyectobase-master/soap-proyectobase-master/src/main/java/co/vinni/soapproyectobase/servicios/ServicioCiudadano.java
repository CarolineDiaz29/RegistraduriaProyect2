package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.CiudadanoDto;
import co.vinni.soapproyectobase.entidades.Ciudadano;
import co.vinni.soapproyectobase.repositorios.RespositorioCiudadano;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ServicioCiudadano implements Serializable {
    private ModelMapper modelMapper;

    @Autowired
    RespositorioCiudadano repoCiudadano;

    public void registrarCiudadano(CiudadanoDto ciudadanoDto) {
        repoCiudadano.save(modelMapper.map(ciudadanoDto, Ciudadano.class));
    }
    public List<CiudadanoDto> consultarCiudadanos() {
        TypeToken<List<CiudadanoDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoCiudadano.findAll(), typeToken.getType());
    }

}
