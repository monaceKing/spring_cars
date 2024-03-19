package traning.api.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import traning.api.springBoot.entities.Car;

@Repository
public interface GarageRepositoryImpl extends JpaRepository<Car, Long> {
	
}
