package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Bandera;

@Repository
public interface BanderaRepository extends JpaRepository<Bandera, Integer> {
	
}