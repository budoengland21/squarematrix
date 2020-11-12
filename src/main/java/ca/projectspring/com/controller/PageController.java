package ca.projectspring.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import ca.projectspring.com.solver.SquareMatrix;

@Controller

public class PageController {
	SquareMatrix x;
	
	@GetMapping("/start")
	public String startPage() {
		
		return "Welcome.html";
	}
	
	//after submit the values of welcome page
	//it goes to matrixCreate
	@GetMapping("/secondPage")
	public String build(@RequestParam int length, Model model) {
		 x = new SquareMatrix(length);
	 	x.extract();
		model.addAttribute("myMatrix", x);
		
		return "matrixCreate.html";
		
		
		
	}
	
	//to get the attributes after submitting
	// attribute we need is answer
	// 
	@GetMapping("/matrixCreate")
	public String searchString(Model model, @ModelAttribute SquareMatrix myMatrix ) {
		String val = myMatrix.getAnswer();
		x.search(val);//it will search for string
		x.extract();
		model.addAttribute("myMatrix", x);
		return "matrixCreate.html";
		
	}

}
