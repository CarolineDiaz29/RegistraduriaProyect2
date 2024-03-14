package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Ciudadano;
import co.vinni.soapproyectobase.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface RespositorioCiudadano extends JpaRepository<Ciudadano, String>, JpaSpecificationExecutor<Ciudadano> {
}
