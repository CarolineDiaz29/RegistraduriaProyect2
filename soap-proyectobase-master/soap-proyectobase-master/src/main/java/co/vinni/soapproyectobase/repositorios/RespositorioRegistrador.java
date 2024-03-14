package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Registrador;
import co.vinni.soapproyectobase.entidades.TipoIdentidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface RespositorioRegistrador extends JpaRepository<Registrador, String>, JpaSpecificationExecutor<Registrador> {

}
