package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Parque;
import co.innovaciones.repository.ParqueRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ParqueService {

	@Autowired
	private ParqueRepository parqueRepository;

	public List<Parque> findAll() {
		return parqueRepository.findAll();
	}

	public Optional<Parque> findById(Integer id) {
		return parqueRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Parque save(Parque entity) {
		return parqueRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Parque entity) {
		parqueRepository.delete(entity);
	}

}
	
