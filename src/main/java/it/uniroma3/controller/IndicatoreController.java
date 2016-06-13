package it.uniroma3.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import it.uniroma3.model.Indicatore;
import it.uniroma3.service.IndicatoreService;


@Controller
@RequestMapping("/indicatore")
public class IndicatoreController extends WebMvcConfigurerAdapter {

	@Autowired
	private IndicatoreService indicatoreService;
	
	@ModelAttribute("indicatore")
	public Indicatore createIndicatoreModel() {
		return new Indicatore();
	}
	
	@RequestMapping(value= "/addIndicatore",method=RequestMethod.POST)
	public ResponseEntity<String> addIndicatore(@ModelAttribute("indicatore") Indicatore indicatore){
		this.indicatoreService.insertIndicatore(indicatore);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value= "/listIndicatori",method=RequestMethod.GET)
	public @ResponseBody List<Indicatore> listIndicatori(){
		return this.indicatoreService.listIndicatore();
	}
	
}
