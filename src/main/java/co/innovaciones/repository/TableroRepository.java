package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Tablero;

@Repository
public interface TableroRepository extends JpaRepository<Tablero, Integer> {
	
}