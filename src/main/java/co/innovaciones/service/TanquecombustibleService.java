package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Tanquecombustible;
import co.innovaciones.repository.TanquecombustibleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TanquecombustibleService {

	@Autowired
	private TanquecombustibleRepository tanquecombustibleRepository;

	public List<Tanquecombustible> findAll() {
		return tanquecombustibleRepository.findAll();
	}

	public Optional<Tanquecombustible> findById(Integer id) {
		return tanquecombustibleRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Tanquecombustible save(Tanquecombustible entity) {
		return tanquecombustibleRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Tanquecombustible entity) {
		tanquecombustibleRepository.delete(entity);
	}

}
	
