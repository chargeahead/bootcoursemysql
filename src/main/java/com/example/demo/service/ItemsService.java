package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Items;
import com.example.demo.repository.ItemsRepository;

@Service
public class ItemsService {
	
   @Autowired
   ItemsRepository itr;
   
   public Optional<Items> get(int itemId) {
     return itr.findById(itemId);
   }
   public List<Items> getAll() {
	   return (List<Items>) itr.findAll();
   }
   public Items update(Items item) {
     return itr.save(item);
   }
   public void delete(Items item) {
     itr.delete(item);
   }
//   /*
//    * Method called after Service bean field initialization 
//    */
//   @PostConstruct 
//   public void init() {
//	   items.add(new Items(1,"Bike",99.99, 10));
//	   items.add(new Items(2,"Treadmill",199.99, 5));
//	   items.add(new Items(3,"Elliptical",250.00, 7));	   
//   }
}
