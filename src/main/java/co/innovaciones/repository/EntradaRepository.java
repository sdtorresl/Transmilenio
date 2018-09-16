package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
	
}