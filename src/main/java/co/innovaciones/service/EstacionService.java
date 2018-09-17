package co.innovaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Estacion;
import co.innovaciones.repository.EstacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EstacionService {

	@Autowired
	private EstacionRepository estacionRepository;

	public List<Estacion> findAll() {
		return estacionRepository.findAll();
	}
}
	
