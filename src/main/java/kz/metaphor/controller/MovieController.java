package kz.metaphor.controller;

import java.util.ArrayList;
import java.util.List;
import kz.metaphor.database.DataGetter;
import kz.metaphor.model.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@RequestMapping( method = RequestMethod.GET,headers="Accept=application/json")
	public List<Movie> getMovies() {
		List<Movie> movies=new ArrayList<Movie>();
		System.out.println("We are in controllers getMovie method");
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		DataGetter dataGetter= (DataGetter) context.getBean("dataGetter");
		movies= dataGetter.getMovies();
		System.out.println("movies length:"+movies.size());
		return movies;
	}
	
	@RequestMapping( method = RequestMethod.GET,headers="Accept=application/json",value="{date}")
	public List<Movie> getMovieByDate(@PathVariable String date) {
		List<Movie> movies=new ArrayList<Movie>();
		System.out.println("We are in controllers getMovieByDate method");
		System.out.println("date: "+date);
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		DataGetter dataGetter= (DataGetter) context.getBean("dataGetter");
		movies= dataGetter.getMoviesByDate(date);
		System.out.println("movies length:"+movies.size());
		return movies;
	}
	
}