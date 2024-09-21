package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDtoResponse;
import com.betrybe.agrix.entity.CropEntity;
import com.betrybe.agrix.service.CropService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping
  public ResponseEntity<List<CropDtoResponse>> getAllCrops() {
    return ResponseEntity.ok().body(cropService.getAllCrops().stream()
            .map(CropDtoResponse::fromEntity)
            .toList());
  }
}
