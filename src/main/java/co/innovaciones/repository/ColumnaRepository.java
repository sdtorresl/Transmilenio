package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Columna;

@Repository
public interface ColumnaRepository extends JpaRepository<Columna, Integer> {
	
}