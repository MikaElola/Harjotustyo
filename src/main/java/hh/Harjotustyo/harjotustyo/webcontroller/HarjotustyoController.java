package hh.Harjotustyo.harjotustyo.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.Harjotustyo.harjotustyo.domain.BookRepository;
import hh.Harjotustyo.harjotustyo.domain.CategoryRepository;
import hh.Harjotustyo.harjotustyo.domain.MovieRepository;
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
	
	}
