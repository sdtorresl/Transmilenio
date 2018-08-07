package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}