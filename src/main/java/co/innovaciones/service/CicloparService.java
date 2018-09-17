package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Ciclopar;
import co.innovaciones.repository.CicloparRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CicloparService {

	@Autowired
	private CicloparRepository cicloparRepository;

	public List<Ciclopar> findAll() {
		return cicloparRepository.findAll();
	}

	public Optional<Ciclopar> findById(Integer id) {
		return cicloparRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Ciclopar save(Ciclopar entity) {
		return cicloparRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Ciclopar entity) {
		cicloparRepository.delete(entity);
	}

}
	
