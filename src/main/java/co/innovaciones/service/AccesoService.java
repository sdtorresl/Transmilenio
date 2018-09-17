package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Acceso;
import co.innovaciones.repository.AccesoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AccesoService {

	@Autowired
	private AccesoRepository accesoRepository;

	public List<Acceso> findAll() {
		return accesoRepository.findAll();
	}

	public Optional<Acceso> findById(Integer id) {
		return accesoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Acceso save(Acceso entity) {
		return accesoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Acceso entity) {
		accesoRepository.delete(entity);
	}

}
	
