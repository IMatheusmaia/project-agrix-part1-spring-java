package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.CropEntity;
import com.betrybe.agrix.repository.CropRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  public CropEntity createCrop(CropEntity crop) {
    return cropRepository.save(crop);
  }

  public List<CropEntity> getAllCrops() {
    return cropRepository.findAll();
  }

  public CropEntity getCropById(Long id) {
    return cropRepository.findById(id).orElse(null);
  }
}
