package co.projetFilrougeCrud.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import co.projetFilrougeCrud.model.Foods;
import co.projetFilrougeCrud.repository.FoodsRepository;

@Named
public class FoodsServiceImpl implements FoodsService {

	@Inject
	FoodsRepository foodsRepository;

	public Foods saveFoods(Foods foods) {
		foodsRepository.save(foods);
		return foods;
	}

	public List<Foods> getAll() {
		return foodsRepository.findAll();
		// return null; // TODO
	}

	public void delete(Long id) {
		foodsRepository.deleteById(id);
	}

	public Optional<Foods> findById(Long id) {
		return foodsRepository.findById(id);

	}

	public List<Foods> findByName(String name) {
		return foodsRepository.findByName(name);
	}
}