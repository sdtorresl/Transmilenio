package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Portamapa;
import co.innovaciones.repository.PortamapaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PortamapaService {

	@Autowired
	private PortamapaRepository portamapaRepository;

	public List<Portamapa> findAll() {
		return portamapaRepository.findAll();
	}

	public Optional<Portamapa> findById(Integer id) {
		return portamapaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Portamapa save(Portamapa entity) {
		return portamapaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Portamapa entity) {
		portamapaRepository.delete(entity);
	}

}
	
