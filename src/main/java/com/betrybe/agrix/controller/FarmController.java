package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FarmDtoCreated;
import com.betrybe.agrix.controller.dto.FarmDtoResponse;
import com.betrybe.agrix.controller.exception.FarmBadRequestException;
import com.betrybe.agrix.entity.FarmEntity;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Gets farms.
   *
   * @return the farms
   */
  @GetMapping
  public ResponseEntity<List<FarmDtoResponse>> getFarms() {
    List<FarmEntity> farms = farmService.getAllFarms();
    return ResponseEntity.ok().body(farms.stream()
            .map(FarmDtoResponse::fromEntity)
            .toList());
  }

  /**
   * Create farm response entity.
   *
   * @param farmDto the farm dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<FarmDtoResponse> createFarm(@RequestBody FarmDtoCreated farmDto)
          throws FarmBadRequestException {
    if (farmDto.name() == null || farmDto.name().isEmpty()) {
      throw new FarmBadRequestException();
    } else if (farmDto.size() == null || farmDto.size() <= 0) {
      throw new FarmBadRequestException();
    }
    FarmEntity farmResponsedb = farmService.createFarm(FarmDtoCreated.toEntity(farmDto));
    FarmDtoResponse farmResponse = FarmDtoResponse.fromEntity(farmResponsedb);
    return ResponseEntity.status(HttpStatus.CREATED).body(farmResponse);
  }
}
