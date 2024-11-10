package is.lessons.spring.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String indexPizze(Model model){
		
		model.addAttribute("pizze", pizzeRepo.findAll());
		model.addAttribute("fritti", frittiRepo.findAll());
		model.addAttribute("bevande", bevandeRepo.findAll());
		return "pizze/lista-pizze";
	}
	
	
	@GetMapping("/pizze/{id}")
	public String infoPizza(@PathVariable String id, Model model){
		
		int a = Integer.parseInt(id);
		model.addAttribute("infoPizza", pizzeRepo.getOne(a));
		return "pizze/info-pizza";
	}
	
}
