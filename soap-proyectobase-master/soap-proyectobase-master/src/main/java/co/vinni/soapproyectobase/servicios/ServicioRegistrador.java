package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.RegistradorDto;
import co.vinni.soapproyectobase.entidades.Registrador;
import co.vinni.soapproyectobase.repositorios.RespositorioRegistrador;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServicioRegistrador implements Serializable {
    private ModelMapper modelMapper;

    @Autowired
    RespositorioRegistrador repoRegis;


    public void registrarRegistrador(RegistradorDto registradorDto) {
        repoRegis.save(modelMapper.map(registradorDto, Registrador.class));
    }

    public List<Registrador> consultarRegistradores() {
        TypeToken<List<RegistradorDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoRegis.findAll(), typeToken.getType());
    }
}
