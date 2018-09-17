package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Subestacion;
import co.innovaciones.repository.SubestacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SubestacionService {

	@Autowired
	private SubestacionRepository subestacionRepository;

	public List<Subestacion> findAll() {
		return subestacionRepository.findAll();
	}

	public Optional<Subestacion> findById(Integer id) {
		return subestacionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Subestacion save(Subestacion entity) {
		return subestacionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Subestacion entity) {
		subestacionRepository.delete(entity);
	}

}
	
