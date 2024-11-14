package is.lessons.spring.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import is.lessons.spring.pizzeria.model.Bevande;
import is.lessons.spring.pizzeria.model.Fritti;
import is.lessons.spring.pizzeria.model.Pizza;
import is.lessons.spring.pizzeria.repository.BevandeRepository;
import is.lessons.spring.pizzeria.repository.FrittiRepository;
import is.lessons.spring.pizzeria.repository.PizzeRepository;

@Controller
@RequestMapping("/")
public class PizzeController {

	@Autowired
	private PizzeRepository pizzeRepo;
	
	@Autowired
	private FrittiRepository frittiRepo;
	
	@Autowired
	private BevandeRepository bevandeRepo;
	
	@GetMapping("/pizze")
	public String indexPizze(@RequestParam(name = "keyword", required= false) String keyword, Model model){
		
		List <Pizza> elencoPizze;
		List <Bevande> elencoBevande;
		List <Fritti> elencoFritti;
		
		if (keyword != null && !keyword.isBlank()) {
		
			elencoPizze = pizzeRepo.findByNomePizzaOrDescrizioneContaining(keyword, keyword);
			elencoBevande = bevandeRepo.findByNomeBevandaContaining(keyword);
			elencoFritti = frittiRepo.findByNomeFrittoContaining(keyword);
			model.addAttribute("keyword", keyword);
		
		}
		else {
			elencoPizze = pizzeRepo.findAll();
			elencoBevande = bevandeRepo.findAll();
			elencoFritti = frittiRepo.findAll();
			}
		
		model.addAttribute("pizze", elencoPizze);
		model.addAttribute("fritti", elencoFritti);
		model.addAttribute("bevande", elencoBevande);
		return "pizze/lista-pizze";
	}
	
	
	@GetMapping("/pizze/{id}")
	public String infoPizza(@PathVariable String id, Model model){
		
		int a = Integer.parseInt(id);
		model.addAttribute("infoPizza", pizzeRepo.getOne(a));
		return "pizze/info-pizza";
	}
	
}
