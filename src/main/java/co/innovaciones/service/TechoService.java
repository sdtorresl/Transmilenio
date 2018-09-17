package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Techo;
import co.innovaciones.repository.TechoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TechoService {

	@Autowired
	private TechoRepository techoRepository;

	public List<Techo> findAll() {
		return techoRepository.findAll();
	}

	public Optional<Techo> findById(Integer id) {
		return techoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Techo save(Techo entity) {
		return techoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Techo entity) {
		techoRepository.delete(entity);
	}

}
	
