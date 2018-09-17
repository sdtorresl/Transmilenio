package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import co.innovaciones.model.Troncal;
import co.innovaciones.repository.TroncalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TroncalService {

	@Autowired
	private TroncalRepository troncalRepository;

	public List<Troncal> findAll() {
		return troncalRepository.findAll();
	}

	public Optional<Troncal> findById(Integer id) {
		return troncalRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Troncal save(Troncal entity) {
		return troncalRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Troncal entity) {
		troncalRepository.delete(entity);
	}

}
