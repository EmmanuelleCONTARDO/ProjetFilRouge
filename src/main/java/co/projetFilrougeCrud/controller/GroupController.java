package co.projetFilrougeCrud.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import co.projetFilrougeCrud.model.FoodsGroup;
import co.projetFilrougeCrud.service.GroupService;


@Controller
@RequestMapping ("/FoodsGroup")
public class GroupController {
	
	@Inject
	GroupService groupService;


@RequestMapping(method = RequestMethod.POST)
@ResponseStatus(HttpStatus.CREATED)
@ResponseBody
public Long create(@RequestBody FoodsGroup resource) {
	return groupService.saveGroup(resource).getId();
	//System.out.println(resource);
	//return 1L;
}
}
