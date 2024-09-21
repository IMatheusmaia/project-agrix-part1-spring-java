package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.CropEntity;
import com.betrybe.agrix.entity.FarmEntity;

/**
 * The type Crop dto created.
 */
public record CropDtoCreated(String name, Double plantedArea) {
  /**
   * To entity crop entity.
   *
   * @param cropDto the crop dto
   * @return the crop entity
   */
  public static CropEntity toEntity(CropDtoCreated  cropDto, FarmEntity farm) {

    CropEntity crop = new CropEntity();
    crop.setName(cropDto.name());
    crop.setPlantedArea(cropDto.plantedArea());
    crop.setFarm(farm);
    return crop;
  }
}
