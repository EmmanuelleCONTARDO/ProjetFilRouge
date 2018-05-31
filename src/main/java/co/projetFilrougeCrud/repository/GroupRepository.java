package co.projetFilrougeCrud.repository;

import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import co.projetFilrougeCrud.model.FoodsGroup;

@Named
public interface GroupRepository extends JpaRepository<FoodsGroup, Long>{

	List<FoodsGroup> findByName(String name);
	Optional<FoodsGroup> findById(Long Id);
	public List<FoodsGroup> findByNameLike(@Param("name") String name);
	
	
}
