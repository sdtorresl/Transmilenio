package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Isquiatico;
import co.innovaciones.repository.IsquiaticoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class IsquiaticoService {

	@Autowired
	private IsquiaticoRepository isquiaticoRepository;

	public List<Isquiatico> findAll() {
		return isquiaticoRepository.findAll();
	}

	public Optional<Isquiatico> findById(Integer id) {
		return isquiaticoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Isquiatico save(Isquiatico entity) {
		return isquiaticoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Isquiatico entity) {
		isquiaticoRepository.delete(entity);
	}

}
	
