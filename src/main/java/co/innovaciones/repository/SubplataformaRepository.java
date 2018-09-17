package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Subplataforma;

@Repository
public interface SubplataformaRepository extends JpaRepository<Subplataforma, Integer> {
	
}