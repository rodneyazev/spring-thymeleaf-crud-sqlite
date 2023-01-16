package com.project.contacts;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
public class ContactsController {

	@Autowired
	private ContactsRepository er;

	@GetMapping("/")
	public ModelAndView eventsList() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Contacts> events = er.findAll(new Sort(Direction.ASC, "department"));	
		return mv.addObject("contacts", events);
	}
	
	@GetMapping("/contacts/add")
	public String eventsAdd() {
		return "contacts/contactsAdd";
	}
	
	@PostMapping("/contacts/add")	
	public String eventsAdd(Contacts events) {
		er.save(events);
		return "redirect:/";
	}
	
    @GetMapping("/contacts/edit/{id}")
	public String eventsEdit(@PathVariable("id") int id, Model model) {
		model.addAttribute("contacts", er.findById(id));
		return "contacts/contactsEdit";
	}
    
    @PostMapping("/contacts/edit/{id}")	
	public String contactsEdit(Contacts events) {
		er.save(events);
		return "redirect:/";
	}
    
    @GetMapping("/contacts/delete/{id}")
    public String eventsDelete(@PathVariable("id") int id) {
		er.deleteById(id);
		return "redirect:/";
    }
	
}
