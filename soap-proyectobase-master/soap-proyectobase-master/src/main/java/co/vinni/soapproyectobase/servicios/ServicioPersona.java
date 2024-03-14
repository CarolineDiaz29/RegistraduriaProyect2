package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.PersonaDto;
import co.vinni.soapproyectobase.dto.TipoIdentidadDto;
import co.vinni.soapproyectobase.entidades.Persona;
import co.vinni.soapproyectobase.repositorios.RespositorioPersona;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ServicioPersona implements Serializable {
    private ModelMapper modelMapper;
    @Autowired
    RespositorioPersona repoPersona;


    public void registrarPersona(PersonaDto personadto) {
        repoPersona.save(modelMapper.map(personadto, Persona.class));
    }

    /*public PersonaDto consultarPersona(int documento) {
        TypeToken<List<PersonaDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoPersona.findById(documento), typeToken.getType());
    }*/

    public List<PersonaDto> consultarPersonas(){
        TypeToken<List<PersonaDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoPersona.findAll(), typeToken.getType());
    }


    public void modificarpersona(PersonaDto personaDto) {
        Persona  persona = modelMapper.map(personaDto, Persona.class);
        this.repoPersona.save(persona);
    }

    /*private boolean existePersonaConDocumento(int documento) {
        return repoPersona.existsById(documento);
    }*/
}
