package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository repo;

	@RequestMapping( value="shipwrecks", method=RequestMethod.GET )
	public List<Shipwreck> 	list() {
		return repo.findAll();
	}//list

	@RequestMapping( value="shipwrecks", method=RequestMethod.POST )
	public Shipwreck create( @RequestBody Shipwreck wreck ) {
		return repo.saveAndFlush(wreck);
	}


	@RequestMapping( value="shipwrecks/{id}", method=RequestMethod.GET )
	public Shipwreck get( @PathVariable Long id ) {
		return repo.findOne(id);
	}


	@RequestMapping( value="shipwrecks/{id}", method=RequestMethod.PUT )
	public Shipwreck update( @PathVariable Long id, @RequestBody Shipwreck wreck2 ) {
		Shipwreck wreck = repo.findOne(id);
		BeanUtils.copyProperties(wreck2, wreck);
		return repo.saveAndFlush(wreck);
	}


	@RequestMapping( value="shipwrecks/{id}", method=RequestMethod.DELETE )
	public Shipwreck delete( @PathVariable Long id ) {
		Shipwreck wreck = repo.findOne(id);
		repo.delete(wreck);
		return wreck;
	}



}//ShipwreckController
