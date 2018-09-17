package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Grifo;
import co.innovaciones.repository.GrifoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GrifoService {

	@Autowired
	private GrifoRepository grifoRepository;

	public List<Grifo> findAll() {
		return grifoRepository.findAll();
	}

	public Optional<Grifo> findById(Integer id) {
		return grifoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Grifo save(Grifo entity) {
		return grifoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Grifo entity) {
		grifoRepository.delete(entity);
	}

}
	
