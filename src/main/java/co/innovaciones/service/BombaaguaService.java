package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Bombaagua;
import co.innovaciones.repository.BombaaguaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BombaaguaService {

	@Autowired
	private BombaaguaRepository bombaaguaRepository;

	public List<Bombaagua> findAll() {
		return bombaaguaRepository.findAll();
	}

	public Optional<Bombaagua> findById(Integer id) {
		return bombaaguaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Bombaagua save(Bombaagua entity) {
		return bombaaguaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Bombaagua entity) {
		bombaaguaRepository.delete(entity);
	}

}
	
