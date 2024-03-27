package traning.api.springBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class GarageController {
    
    @Autowired
    private GarageServiceImpl serviceImpl;
    
    
    //Recuperer la liste des voitures
    @GetMapping(path = "/list")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = serviceImpl.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
    
    @GetMapping(path = "/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("{\"message\": \"Récupère moi dans Angular si tu l'ose. Je suis dans le controleur Spring\"}");
    }
    
    //Recherche une voiture par id
    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable Long id){
        Car car = serviceImpl.findCarById(id);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(car, HttpStatus.OK);
        }
    }
    
    
    //Creation d'une voiture
    @PostMapping(path = "/create")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = serviceImpl.createCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }
    

    //Modifier une voiture
    @PutMapping(path = "/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        Car updatedCar = serviceImpl.updateCar(car);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }
    
    
    //supprimer une voiture
    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        serviceImpl.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}
