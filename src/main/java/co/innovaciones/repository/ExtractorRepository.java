package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Extractor;

@Repository
public interface ExtractorRepository extends JpaRepository<Extractor, Integer> {
	
}