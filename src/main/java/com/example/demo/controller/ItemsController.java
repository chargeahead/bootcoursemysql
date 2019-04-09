package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Items;
import com.example.demo.service.ItemsService;

@Controller
@RequestMapping("/inventory")
public class ItemsController {
	@Autowired
	ItemsService its;
    //Display all items
	@RequestMapping(value= {"/all","/"})
	public String getAll(Model model){
		List<Items> items = its.getAll();
		System.out.println(items.size());
		model.addAttribute("items", items);
		model.addAttribute("heading", "Item Inventory");
		return "itemsViewWithBootstrap";
		//return "itemsView";
	}
	
	//Edit an item
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,Model model){
		Optional<Items> i = its.get(id);
		System.out.println("item to edit is "+i.get().getItemId());
		model.addAttribute("item", i);
		model.addAttribute("heading", "Edit Item");
		return "editView";
	}
	
	//Edit and add action send it to update which will insert/update
	@RequestMapping("/update")
	public String edit(Model model, Items item){	
		System.out.println("item in update is "+item.getItemId());
		its.update(item);
		List<Items> items = its.getAll();
		model.addAttribute("items", items);
		model.addAttribute("heading", "Item Inventory");
		//return "itemsViewWithBootstrap";
		return "redirect:/inventory/all";
	} 
	//Add an item
	@RequestMapping("/add")
	public String add(Model model){
		Items i = new Items();
		System.out.println("Adding item ");
		model.addAttribute("item", i);
		model.addAttribute("heading", "Add Item");
		return "editView";
	}
	//delete an item
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id,Model model){	
		Optional<Items> i = its.get(id);
		System.out.println("item to delete is "+i.get().getItemId());
		its.delete(i.get());
		List<Items> items = its.getAll();
		model.addAttribute("items", items);
		model.addAttribute("heading", "Item Inventory");
		return "redirect:/inventory/all";
	}
}
