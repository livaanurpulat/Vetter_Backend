package com.backend.vetter.Resource;

import com.backend.vetter.DTO.PetDTO;
import com.backend.vetter.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetter-api")
public class PetResource {

    @Autowired
    PetService petService;

    @GetMapping("/pet-delete/{id}")
    public ResponseEntity<Boolean> petDelete (@PathVariable("id")Long id){
        return ResponseEntity.ok(petService.delete(id));
    }
    @PostMapping("/pet-add")
    public ResponseEntity<PetDTO> petAdd (@RequestBody PetDTO petDTO){
        return ResponseEntity.ok(petService.add(petDTO));
    }
    @GetMapping("/pet-get-all")
    public ResponseEntity<List<PetDTO>> petGetAll(){
        return ResponseEntity.ok(petService.getAll());
    }
}
