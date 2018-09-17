package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Barreraper;
import co.innovaciones.repository.BarreraperRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BarreraperService {

	@Autowired
	private BarreraperRepository barreraperRepository;

	public List<Barreraper> findAll() {
		return barreraperRepository.findAll();
	}

	public Optional<Barreraper> findById(Integer id) {
		return barreraperRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Barreraper save(Barreraper entity) {
		return barreraperRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Barreraper entity) {
		barreraperRepository.delete(entity);
	}

}
	
