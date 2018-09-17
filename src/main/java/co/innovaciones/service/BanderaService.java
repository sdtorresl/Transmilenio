package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Bandera;
import co.innovaciones.repository.BanderaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BanderaService {

	@Autowired
	private BanderaRepository banderaRepository;

	public List<Bandera> findAll() {
		return banderaRepository.findAll();
	}

	public Optional<Bandera> findById(Integer id) {
		return banderaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Bandera save(Bandera entity) {
		return banderaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Bandera entity) {
		banderaRepository.delete(entity);
	}

}
	
