package com.betrybe.agrix.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The type Crop entity.
 */
@Entity
@Table(name = "crops")
public class CropEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private FarmEntity farm;

  public CropEntity() {
  }

  /**
   * Instantiates a new Crop entity.
   *
   * @param id          the id
   * @param name        the name
   * @param plantedArea the planted area
   */
  public CropEntity(Long id, String name, Double plantedArea) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public FarmEntity getFarm() {
    return farm;
  }

  public void setFarm(FarmEntity farm) {
    this.farm = farm;
  }
}
