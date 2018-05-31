package co.projetFilrougeCrud.controller;

import java.util.List;
import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.projetFilrougeCrud.model.Foods;
import co.projetFilrougeCrud.service.FoodsService;




@Controller
@RequestMapping ("/Foods")
public class FoodsController {

	@Inject
FoodsService foodsService;
//			
//	@RequestMapping(method = RequestMethod.GET)
//	@ResponseBody
//	public List<Foods> findAll() {
//		Group group = new Group(1L, "Légumes");
//		 List<Foods> foods = new ArrayList<Foods>();
//		 foods.add(new Foods(1L,"Carottes",group , 23.1f, 11.2f, 11.2f, 11.3f, 11.4f, "Commentaires"));
//		 
//		 return foods;
	//	return foodsService.getAll();
	//}


	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Long create(@RequestBody Foods resource) {
		return foodsService.saveFoods(resource).getId();
		//System.out.println(resource);
		//return 1L;
	}



}
