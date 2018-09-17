package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Fotoelectrica;

@Repository
public interface FotoelectricaRepository extends JpaRepository<Fotoelectrica, Integer> {
	
}