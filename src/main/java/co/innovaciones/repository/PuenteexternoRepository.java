package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Puenteexterno;

@Repository
public interface PuenteexternoRepository extends JpaRepository<Puenteexterno, Integer> {
	
}