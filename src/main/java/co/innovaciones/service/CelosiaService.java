package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Celosia;
import co.innovaciones.repository.CelosiaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CelosiaService {

	@Autowired
	private CelosiaRepository celosiaRepository;

	public List<Celosia> findAll() {
		return celosiaRepository.findAll();
	}

	public Optional<Celosia> findById(Integer id) {
		return celosiaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Celosia save(Celosia entity) {
		return celosiaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Celosia entity) {
		celosiaRepository.delete(entity);
	}

}
	
