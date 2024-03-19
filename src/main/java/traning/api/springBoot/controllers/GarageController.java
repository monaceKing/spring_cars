package traning.api.springBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import traning.api.springBoot.entities.Car;
import traning.api.springBoot.services.GarageServiceImpl;

@RestController
@RequestMapping("car")
public class GarageController {
	
	@Autowired
	private GarageServiceImpl serviceImpl;
	
	
	//Recuperer la liste des voitures
	@GetMapping
	public List<Car> getAllCars(){
		return serviceImpl.getAllCars();
	}
	
	@PostMapping(path = "/test")
	public String test() {
		return "Bien passons...";
	}
	
	//Recherche une voiture par id
	@GetMapping(path = "/find/{id}")
	public ResponseEntity<Car> findCarById(@PathVariable Long id){
		Car car = serviceImpl.findCarById(id);
		if (car == null) {
			return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Car>(car, HttpStatus.OK);
		}
	}
	
	
	//Creation d'une voiture
	@PostMapping(path = "/create")
	public Car createCar(@RequestBody Car car) {
		return serviceImpl.createCar(car);
	}
	

	//Modifier une voiture
	@PutMapping(path = "/update")
	public Car updateCar(@RequestBody Car car) {
		return serviceImpl.updateCar(car);
	}
	
	
	//supprimer une voiture
	@DeleteMapping(path = "delete/{id}")
	public void deleteCar(@PathVariable Long id) {
		 serviceImpl.deleteCar(id);
	}
	
	
}
