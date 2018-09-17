package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Rampa;
import co.innovaciones.repository.RampaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RampaService {

	@Autowired
	private RampaRepository rampaRepository;

	public List<Rampa> findAll() {
		return rampaRepository.findAll();
	}

	public Optional<Rampa> findById(Integer id) {
		return rampaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Rampa save(Rampa entity) {
		return rampaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Rampa entity) {
		rampaRepository.delete(entity);
	}

}
	
