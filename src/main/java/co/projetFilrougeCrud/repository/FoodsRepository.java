package co.projetFilrougeCrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.projetFilrougeCrud.model.Foods;


public interface FoodsRepository extends JpaRepository<Foods, Long> {
	
	List<Foods> findByName(String name);
	Optional<Foods> findById(Long Id);
	public List<Foods> findByNameLike(@Param("name") String name);
	
}
