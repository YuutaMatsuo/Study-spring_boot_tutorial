package train.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import train.model.Person;

@Controller
public class PersonController {
	private List<Person> plist;
	
	//コンストラクタでフィールドを設定
	public PersonController() {
		plist = new ArrayList<>();
		plist.add(new Person(1,"sample", 12));
	}
	
	@GetMapping("/personapp")
	public String getPerson() {
		return "people";
	}
	
	@PostMapping("/personapp")
	public String postPerson(Person p, Model model) {
		plist.add(p);
		model.addAttribute("plist", plist);
		return "people";
	}
}
