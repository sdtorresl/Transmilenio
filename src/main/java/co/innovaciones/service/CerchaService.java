package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Cercha;
import co.innovaciones.repository.CerchaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CerchaService {

	@Autowired
	private CerchaRepository cerchaRepository;

	public List<Cercha> findAll() {
		return cerchaRepository.findAll();
	}

	public Optional<Cercha> findById(Integer id) {
		return cerchaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Cercha save(Cercha entity) {
		return cerchaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Cercha entity) {
		cerchaRepository.delete(entity);
	}

}
	
