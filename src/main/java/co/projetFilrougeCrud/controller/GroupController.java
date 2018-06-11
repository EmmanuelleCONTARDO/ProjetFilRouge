package co.projetFilrougeCrud.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.projetFilrougeCrud.model.Foods;
import co.projetFilrougeCrud.model.FoodsGroup;
import co.projetFilrougeCrud.service.GroupService;

@Controller
@RequestMapping("/FoodsGroup")
public class GroupController {

	@Inject
	GroupService groupService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FoodsGroup> findAll() {
		return groupService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Long create(@RequestBody FoodsGroup resource) {
		return groupService.saveGroup(resource).getId();
		// System.out.println(resource);
		// return 1L;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletee(@PathVariable(value = "id") Long id) {
		groupService.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@PathVariable(value = "id") Long id, @RequestBody FoodsGroup resource) {
		resource.setId(id);		
		groupService.saveGroup(resource).getId();
	}
	
	
	// Recherche par nom de groupe
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
		public List<FoodsGroup> findByName(@PathVariable(value="name") String name) {
		System.out.println("name = " + name);
		return groupService.findByName(name);
	}
	
}
