package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Subestacion;

@Repository
public interface SubestacionRepository extends JpaRepository<Subestacion, Integer> {
	
}