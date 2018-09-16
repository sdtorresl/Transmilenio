package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Entrance;
import co.innovaciones.repository.EntranceRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EntranceService {

	@Autowired
	private EntranceRepository entranceRepository;

	public List<Entrance> findAll() {
		return entranceRepository.findAll();
	}

	public Optional<Entrance> findById(Integer id) {
		return entranceRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Entrance save(Entrance entity) {
		return entranceRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Entrance entity) {
		entranceRepository.delete(entity);
	}

}
	
