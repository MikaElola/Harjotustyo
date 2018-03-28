package hh.Harjotustyo.harjotustyo.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.Harjotustyo.harjotustyo.domain.Book;
import hh.Harjotustyo.harjotustyo.domain.BookRepository;
import hh.Harjotustyo.harjotustyo.domain.CategoryRepository;
import hh.Harjotustyo.harjotustyo.domain.Movie;
import hh.Harjotustyo.harjotustyo.domain.MovieRepository;
import hh.Harjotustyo.harjotustyo.domain.Music;
import hh.Harjotustyo.harjotustyo.domain.MusicRepository;

@Controller
public class HarjotustyoController {
	@Autowired
	private MusicRepository musicrepo;
	@Autowired 
	private MovieRepository mrepo;
	@Autowired
	private CategoryRepository crepo;
	@Autowired
	private BookRepository brepo;

	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	 @RequestMapping(value="/savebook", method=RequestMethod.POST)
	 public String saveBook(Book book){
	brepo.save(book);
	return "redirect:listBooks";
	}
	 @RequestMapping(value="/savemovie", method=RequestMethod.POST)
	 public String saveMovie(Movie movie){
	mrepo.save(movie);
	return "redirect:listMovie";
	}
	 @RequestMapping(value="/savemusic", method=RequestMethod.POST)
	 public String saveMusic(Music music){
	musicrepo.save(music);
	return "redirect:listMusic";
	} 
	
	 @RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	 public String deleteBook(@PathVariable("id") Long bookID, Model model) {
	 brepo.delete(bookID);
	 return "redirect:../listBooks";
	 } 
	
	 @RequestMapping(value = "/deletemovie/{id}", method = RequestMethod.GET)
	 public String deleteMovie(@PathVariable("id") Long movieID, Model model) {
	 mrepo.delete(movieID);
	 return "redirect:../listMovie";
	 }  

	 @RequestMapping(value = "/deletemusic/{id}", method = RequestMethod.GET)
	 public String deleteMusic(@PathVariable("id") Long musicID, Model model) {
	 musicrepo.delete(musicID);
	 return "redirect:../listMusic";
	 } 
	 
	@RequestMapping(value="/editbook/{id}", method=RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookID, Model model){
		model.addAttribute("book", brepo.findOne(bookID));
		return "editBook";
	}
	
	@RequestMapping(value="/editmovie/{id}", method=RequestMethod.GET)
	public String editMovie(@PathVariable("id") Long movieID, Model model){
		model.addAttribute("movie", mrepo.findOne(movieID));
		return "editMovie";
	}
	
	@RequestMapping(value="/editmusic/{id}", method=RequestMethod.GET)
	public String editMusic(@PathVariable("id") Long musicID, Model model){
		model.addAttribute("music", musicrepo.findOne(musicID));
		return "editMusic";
	}
	
	@RequestMapping(value="/addMusic")
	public String addMusic(Model model){
		model.addAttribute("music", new Music());
		return "addMusic";
	}
	
	@RequestMapping(value="/addMovie")
	public String addMovie(Model model){
		model.addAttribute("movie", new Movie());
		return "addMovie";
	}
	
	@RequestMapping(value="/addBook")
	public String addBook(Model model){
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model){
	model.addAttribute("categories", crepo.findAll());
	return "index";
	}
	
	@RequestMapping(value="/listMovie", method=RequestMethod.GET)
	public String Leffalistaus(Model model){
		model.addAttribute("movies", mrepo.findAll());
		return "listMovie";
	}
	
	@RequestMapping(value="/listMusic", method=RequestMethod.GET)
	public String Musalistaus(Model model){
		model.addAttribute("musics", musicrepo.findAll());
		return "listMusic";
	}
	
	@RequestMapping(value="/listBooks", method=RequestMethod.GET)
	public String KirjaListaus(Model model){
		model.addAttribute("books", brepo.findAll());
		return "listBooks";
	}
	
	
	//Restfull services
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>)brepo.findAll();
	}
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id") Long bookID){
	return brepo.findOne(bookID);
	}
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public @ResponseBody List<Movie> movieListRest(){
		return (List<Movie>)mrepo.findAll();
	}
	@RequestMapping(value="/movie/{id}", method=RequestMethod.GET)
	public @ResponseBody Movie findMovieRest(@PathVariable("id") Long movieID){
		return mrepo.findOne(movieID);
	}
	
	@RequestMapping(value="/musics", method=RequestMethod.GET)
	public @ResponseBody List<Music> musicListRest(){
		return (List<Music>)musicrepo.findAll();
	}
	@RequestMapping(value="/music/{id}", method=RequestMethod.GET)
	public @ResponseBody Music findMusicRest(@PathVariable("id") Long musicID){
		return musicrepo.findOne(musicID);
	}
	
	}
