package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Nacimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;
import java.util.List;


public interface RespositorionNacimientos extends JpaRepository<Nacimientos, Integer>, JpaSpecificationExecutor<Nacimientos> {
}
