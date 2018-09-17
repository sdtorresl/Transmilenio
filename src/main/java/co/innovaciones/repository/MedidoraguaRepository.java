package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Medidoragua;

@Repository
public interface MedidoraguaRepository extends JpaRepository<Medidoragua, Integer> {
	
}