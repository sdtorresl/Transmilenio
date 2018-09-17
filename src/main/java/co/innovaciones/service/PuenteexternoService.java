package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Puenteexterno;
import co.innovaciones.repository.PuenteexternoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PuenteexternoService {

	@Autowired
	private PuenteexternoRepository puenteexternoRepository;

	public List<Puenteexterno> findAll() {
		return puenteexternoRepository.findAll();
	}

	public Optional<Puenteexterno> findById(Integer id) {
		return puenteexternoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Puenteexterno save(Puenteexterno entity) {
		return puenteexternoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Puenteexterno entity) {
		puenteexternoRepository.delete(entity);
	}

}
	
