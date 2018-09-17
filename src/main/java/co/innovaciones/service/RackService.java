package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Rack;
import co.innovaciones.repository.RackRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RackService {

	@Autowired
	private RackRepository rackRepository;

	public List<Rack> findAll() {
		return rackRepository.findAll();
	}

	public Optional<Rack> findById(Integer id) {
		return rackRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Rack save(Rack entity) {
		return rackRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Rack entity) {
		rackRepository.delete(entity);
	}

}
	
