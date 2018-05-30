package co.projetFilrougeCrud.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import co.projetFilrougeCrud.model.Foods;

@Named
public interface FoodsService {
	public Foods saveFoods(Foods f);
	public List<Foods> getAll();
	public Optional<Foods> findById(Long id);
	public List<Foods> findByName(String name);
	public void delete(Long id);

}
