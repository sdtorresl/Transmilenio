package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Barrerapasamano;
import co.innovaciones.repository.BarrerapasamanoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BarrerapasamanoService {

	@Autowired
	private BarrerapasamanoRepository barrerapasamanoRepository;

	public List<Barrerapasamano> findAll() {
		return barrerapasamanoRepository.findAll();
	}

	public Optional<Barrerapasamano> findById(Integer id) {
		return barrerapasamanoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Barrerapasamano save(Barrerapasamano entity) {
		return barrerapasamanoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Barrerapasamano entity) {
		barrerapasamanoRepository.delete(entity);
	}

}
	
