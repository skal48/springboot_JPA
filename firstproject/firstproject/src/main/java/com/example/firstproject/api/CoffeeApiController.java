package com.example.firstproject.api;

import com.example.firstproject.DTO.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CoffeeApiController {
  @Autowired
  private CoffeeRepository coffeeRepository;

  @GetMapping("/api/coffees")
  public List<Coffee> index() {
    return coffeeRepository.findAll();
  }

  @GetMapping("/api/coffees/{id}")
  public Coffee show(@PathVariable Long id){
    return coffeeRepository.findById(id).orElse(null);
  }

  @PostMapping("/api/coffes")
  public Coffee create(@RequestBody CoffeeDto dto){
    Coffee coffee = dto.toEntity();
    return coffeeRepository.save(coffee);
  }

  @PatchMapping("/api/coffees/{id}")
  public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeDto dto){
    Coffee coffee =dto.toEntity();
    Coffee target = coffeeRepository.findById(id).orElse(null);
    if(target == null){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    target.patch(coffee);
    Coffee updated = coffeeRepository.save(target);
    return ResponseEntity.status(HttpStatus.OK).body(updated);
  }

  @DeleteMapping("/api/coffees/{id}")
  public ResponseEntity<Coffee> delete(@PathVariable Long id) {
    Coffee target = coffeeRepository.findById(id).orElse(null);
    if(target == null){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    coffeeRepository.delete(target);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
