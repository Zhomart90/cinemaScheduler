package kz.metaphor.controller;

import java.util.ArrayList;
import java.util.List;

import kz.metaphor.model.Movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/user/")
public class MovieController {

	@RequestMapping( method = RequestMethod.GET,headers="Accept=application/json")
	public List<Movie> getMovie() {
		 System.out.println("get movie method is running");
		 List movies=new ArrayList<Movie>();
		 Movie movie = new Movie();
		 movie.setName("Titanic");
		 movie.setProducer("Cameron");
		 movies.add(movie);
		 Movie movie2 = new Movie();
		 movie2.setName("Troya");
		 movie2.setProducer("Cameron");
		 movies.add(movie2);
		 Movie movie3 = new Movie();
		 movie3.setName("Anaboliki");
		 movie3.setProducer("Bekmambetov");
		 movies.add(movie3);
		 return movies;

//		model.addAttribute("movie", name);
//		return "list";

	}
	
}