package com.project.contacts;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
public class ContactsController {

	@Autowired
	private ContactsRepository er;

	@RequestMapping("/")
	public ModelAndView eventsList() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Contacts> events = er.findAll(new Sort(Direction.ASC, "department"));	
		mv.addObject("contacts", events);
		return mv;
	}
	
	@RequestMapping(value="/contacts/add", method=RequestMethod.GET)
	public String eventsAdd() {
		return "contacts/contactsAdd";
	}
	
	@RequestMapping(value="/contacts/add", method=RequestMethod.POST)	
	public String eventsAdd(Contacts events) {
		er.save(events);
		return "redirect:/";
	}
	
    @RequestMapping(value="/contacts/edit/{id}")
	public String eventsEdit(@PathVariable("id") int id, Model model) {
		model.addAttribute("contacts", er.findById(id));
		return "contacts/contactsEdit";
	}
    
    @RequestMapping(value="/contacts/edit/{id}", method=RequestMethod.POST)	
	public String contactsEdit(Contacts events) {
		er.save(events);
		return "redirect:/";
	}
    
    @RequestMapping(value="/contacts/delete/{id}")
    public String eventsDelete(@PathVariable("id") int id) {
		er.deleteById(id);
		return "redirect:/";
    }
	
}
