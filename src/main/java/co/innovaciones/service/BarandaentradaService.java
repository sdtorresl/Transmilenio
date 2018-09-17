package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Barandaentrada;
import co.innovaciones.repository.BarandaentradaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BarandaentradaService {

	@Autowired
	private BarandaentradaRepository barandaentradaRepository;

	public List<Barandaentrada> findAll() {
		return barandaentradaRepository.findAll();
	}

	public Optional<Barandaentrada> findById(Integer id) {
		return barandaentradaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Barandaentrada save(Barandaentrada entity) {
		return barandaentradaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Barandaentrada entity) {
		barandaentradaRepository.delete(entity);
	}

}
	
