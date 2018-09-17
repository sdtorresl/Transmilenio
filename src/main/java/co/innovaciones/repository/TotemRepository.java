package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Totem;

@Repository
public interface TotemRepository extends JpaRepository<Totem, Integer> {
	
}