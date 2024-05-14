package com.example.firstproject.api;

import com.example.firstproject.DTO.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import com.example.firstproject.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@Slf4j
public class CoffeeApiController {
  @Autowired
  private CoffeeService coffeeService;

  @GetMapping("/api/coffees")
  public Iterable<Coffee> index() {
    return coffeeService.index();
  }

  @GetMapping("/api/coffees/{id}")
  public ResponseEntity<Coffee> show(@PathVariable Long id){
    Coffee showed = coffeeService.show(id);
    return (showed != null) ?
            ResponseEntity.status(HttpStatus.OK).body(showed) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @PostMapping("/api/coffes")
  public ResponseEntity<Coffee> create(@RequestBody CoffeeDto dto){
    Coffee created = coffeeService.create(dto);
    return (created != null) ?
            ResponseEntity.status(HttpStatus.OK).body(created) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @PatchMapping("/api/coffees/{id}")
  public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeDto dto){
    Coffee updated = coffeeService.update(id, dto);
    return(updated != null) ?
            ResponseEntity.status(HttpStatus.OK).body(updated) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @DeleteMapping("/api/coffees/{id}")
  public ResponseEntity<Coffee> delete(@PathVariable Long id) {
    Coffee deleted = coffeeService.delete(id);
    return (deleted != null) ?
            ResponseEntity.status(HttpStatus.OK).body(deleted) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

}
