package co.projetFilrougeCrud.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Named;


import co.projetFilrougeCrud.model.FoodsGroup;

@Named
public interface GroupService {
	public FoodsGroup saveGroup(FoodsGroup g);
	public List<FoodsGroup> getAll();
	public Optional<FoodsGroup> findById(Long id);
	public List<FoodsGroup> findByName(String name);
	public void delete(Long id);
}
