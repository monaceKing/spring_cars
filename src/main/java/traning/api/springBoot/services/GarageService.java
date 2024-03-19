package traning.api.springBoot.services;

import java.util.List;

import traning.api.springBoot.entities.Car;

public interface GarageService {
	
	//Les méthodes CRUD
	public List<Car> getAllCars();
	public Car findCarById(Long id);
	public Car createCar(Car car);
	public Car updateCar(Car car);
	public void deleteCar(Long id);
	
}
