package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Camara;
import co.innovaciones.repository.CamaraRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CamaraService {

	@Autowired
	private CamaraRepository camaraRepository;

	public List<Camara> findAll() {
		return camaraRepository.findAll();
	}

	public Optional<Camara> findById(Integer id) {
		return camaraRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Camara save(Camara entity) {
		return camaraRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Camara entity) {
		camaraRepository.delete(entity);
	}

}
	
