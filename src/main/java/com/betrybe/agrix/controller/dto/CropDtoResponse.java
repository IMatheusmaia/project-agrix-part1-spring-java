package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.CropEntity;
import com.betrybe.agrix.entity.FarmEntity;

/**
 * The type Crop dto response.
 */
public record CropDtoResponse(Long id, String name, Double plantedArea, Long farmId) {
  /**
   * From entity crop dto response.
   *
   * @param cropEntity the crop entity
   * @return the crop dto response
   */
  public static CropDtoResponse fromEntity(CropEntity cropEntity) {
    return new CropDtoResponse(cropEntity.getId(), cropEntity.getName(),
        cropEntity.getPlantedArea(), cropEntity.getFarm().getId());
  }
}
