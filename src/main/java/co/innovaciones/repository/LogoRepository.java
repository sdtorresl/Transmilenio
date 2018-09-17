package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Logo;

@Repository
public interface LogoRepository extends JpaRepository<Logo, Integer> {
	
}