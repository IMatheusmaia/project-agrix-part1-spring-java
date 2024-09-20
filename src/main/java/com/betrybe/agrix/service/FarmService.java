package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.FarmEntity;
import com.betrybe.agrix.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public FarmEntity createFarm(FarmEntity farm) {
    return farmRepository.save(farm);
  }

  public List<FarmEntity> getAllFarms() {
    return farmRepository.findAll();
  }
}
