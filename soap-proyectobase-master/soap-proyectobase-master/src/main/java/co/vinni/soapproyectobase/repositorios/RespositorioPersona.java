package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;




public interface RespositorioPersona extends JpaRepository<Persona, Integer>, JpaSpecificationExecutor<Persona> {

}
