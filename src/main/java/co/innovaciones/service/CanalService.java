package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Canal;
import co.innovaciones.repository.CanalRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CanalService {

	@Autowired
	private CanalRepository canalRepository;

	public List<Canal> findAll() {
		return canalRepository.findAll();
	}

	public Optional<Canal> findById(Integer id) {
		return canalRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Canal save(Canal entity) {
		return canalRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Canal entity) {
		canalRepository.delete(entity);
	}

}
	
