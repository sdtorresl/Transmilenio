package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Totem;
import co.innovaciones.repository.TotemRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TotemService {

	@Autowired
	private TotemRepository totemRepository;

	public List<Totem> findAll() {
		return totemRepository.findAll();
	}

	public Optional<Totem> findById(Integer id) {
		return totemRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Totem save(Totem entity) {
		return totemRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Totem entity) {
		totemRepository.delete(entity);
	}

}
	
