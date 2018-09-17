package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Integer> {
	
}