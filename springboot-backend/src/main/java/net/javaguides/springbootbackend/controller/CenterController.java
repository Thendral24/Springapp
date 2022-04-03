package net.javaguides.springbootbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.model.Center;
import net.javaguides.springbootbackend.repository.CenterRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1/")
public class CenterController {
    @Autowired
    private CenterRepository centerrepository;
    //get all center

    @GetMapping("/centers")
    public List<Center> getAllCenters() {
        return centerrepository.findAll();

    }
    // create center rest api
    @PostMapping("/centers")
     public Center createCenter(@RequestBody Center Center) {
         return centerrepository.save(Center);
    }
    //get  by id rest api 
     @GetMapping("/centers/{id}")
    public ResponseEntity<Center> getCenterById(@PathVariable Long id) {
       Center Center = centerrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Center not exist with id: " + id));
       return ResponseEntity.ok(Center);

    }
    //update rest api
      @PutMapping("/centers/{id}")
      public ResponseEntity<Center> updateCenter(@PathVariable Long id,@RequestBody Center CenterDetails) {
          Center Center = centerrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Center not exist with id: " + id));
          Center.setCentername(CenterDetails.getCentername());
          Center.setAddress(CenterDetails.getAddress());
          Center.setPhonenumber(CenterDetails.getPhonenumber());
          Center.setImageurl(CenterDetails.getImageurl());
          Center.setEmail(CenterDetails.getEmail());
          Center.setDescription(CenterDetails.getDescription());
          Center updatedCenter = centerrepository.save(Center);
          return ResponseEntity.ok(updatedCenter);

     }
     //delete center
     @DeleteMapping("/centers/{id}")
     public ResponseEntity<Map<String, Boolean>> deleteCenter(@PathVariable Long id) {
        Center Center = centerrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Center not exist with id: " + id));
        centerrepository.delete(Center);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
     }

}
