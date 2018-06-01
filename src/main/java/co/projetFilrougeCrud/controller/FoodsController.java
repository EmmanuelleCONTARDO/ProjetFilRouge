package co.projetFilrougeCrud.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.projetFilrougeCrud.model.Foods;
import co.projetFilrougeCrud.service.FoodsService;


@Controller
@RequestMapping("/Foods")
public class FoodsController {

	@Inject
	FoodsService foodsService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Foods> findAll() {
		return foodsService.getAll();
	}

	// Recherche par ID
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Optional<Foods> findById(Long id) {
		return foodsService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Long create(@RequestBody Foods resource) {
		System.out.println(resource);
		return foodsService.saveFoods(resource).getId();
		// return 1L;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletee(@PathVariable(value = "id") Long id) {
		foodsService.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@PathVariable(value = "id") Long id, @RequestBody Foods resource) {
		resource.setId(id);		
		foodsService.saveFoods(resource).getId();
	}
	
	// Recherche par nom de l'aliment
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
		public List<Foods> findByName(@Param("name") String name) {
		return foodsService.findByName("%"+name+"%");
	}
}
