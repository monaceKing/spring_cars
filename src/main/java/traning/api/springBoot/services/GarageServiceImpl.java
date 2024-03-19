package traning.api.springBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import traning.api.springBoot.entities.Car;
import traning.api.springBoot.repositories.GarageRepositoryImpl;

@Service
public class GarageServiceImpl implements GarageService {
	
	//Liaison avec le repository
	@Autowired
	public GarageRepositoryImpl garageRepositoryImpl;

	@Override
	public List<Car> getAllCars() {
		return garageRepositoryImpl.findAll();
	}

	@Override
	public Car findCarById(Long id) {
		Optional<Car> optional = garageRepositoryImpl.findById(id);
		
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
		
	}

	@Override
	public Car createCar(Car car) {
		return garageRepositoryImpl.save(car);
	}

	@Override
	public Car updateCar(Car car) {
		Optional<Car> optional = garageRepositoryImpl.findById(car.getId());
		
		if (optional.isEmpty()) {
			return null;
		} else {
			return garageRepositoryImpl.save(car);
		}
		
	}

	@Override
	public void deleteCar(Long id) {
		garageRepositoryImpl.deleteById(id);
		
	}


}
