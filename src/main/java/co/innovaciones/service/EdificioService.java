package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Edificio;
import co.innovaciones.repository.EdificioRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRepository;

	public List<Edificio> findAll() {
		return edificioRepository.findAll();
	}

	public Optional<Edificio> findById(Integer id) {
		return edificioRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Edificio save(Edificio entity) {
		return edificioRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Edificio entity) {
		edificioRepository.delete(entity);
	}

}
	
