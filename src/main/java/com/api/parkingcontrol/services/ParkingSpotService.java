package com.api.parkingcontrol.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {
  
  final ParkingSpotRepository parkingSpotRepository;

  public ParkingSpotService (ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  @Transactional
  public ParkingSpotModel save( ParkingSpotModel parkingSpotModel) {
    return parkingSpotRepository.save(parkingSpotModel);
  }

   public Page<ParkingSpotModel> findAll(Pageable pageable) {
    return parkingSpotRepository.findAll(pageable);
  }
  
  public Optional<ParkingSpotModel> findById(UUID uuid) {
    return parkingSpotRepository.findById(uuid);
  }

  public boolean existsByLicensePlateCar(String licensePlateCar) {
    return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
  }

  public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
    return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
  }

  public boolean existsByApartamentAndBlock(String apartament, String block) {
    return parkingSpotRepository.existsByApartamentAndBlock(apartament, block);
  }

  public void deleteById(@Valid UUID id) {
    parkingSpotRepository.deleteById(id); 
  }
}
