package co.projetFilrougeCrud.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import co.projetFilrougeCrud.model.FoodsGroup;

import co.projetFilrougeCrud.repository.GroupRepository;

@Named
public class GroupServiceImpl implements GroupService {
	
	@Inject
	GroupRepository groupRepository;

	public FoodsGroup saveGroup(FoodsGroup group) {
		groupRepository.save(group);
		return group;
	}
	
	public List<FoodsGroup> getAll() {
		return groupRepository.findAll();
		// return null; // TODO
	}
	public void delete(Long id) {
		groupRepository.deleteById(id);
	}
	
	public Optional<FoodsGroup> findById(Long id) {
		return groupRepository.findById(id);

	}
	
	public List<FoodsGroup> findByName(String name) {
		return groupRepository.findByName(name);
	}
	
	
}
