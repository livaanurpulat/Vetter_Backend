package com.backend.vetter.Resource;

import com.backend.vetter.DTO.GenusDTO;
import com.backend.vetter.Service.GenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetter-api")
public class GenusResource {

    @Autowired
    GenusService genusService;

    @GetMapping("/genus-delete/{id}")
    public ResponseEntity<Boolean> genusDelete (@PathVariable("id") Long id){
        return ResponseEntity.ok(genusService.delete(id));
    }

    @PostMapping("/genus-add")
    public ResponseEntity<GenusDTO> genusAdd (@RequestBody GenusDTO genusDTO){
        return ResponseEntity.ok(genusService.add(genusDTO));
    }

    @GetMapping("/genus-get-all")
    public ResponseEntity<List<GenusDTO>> genusGetAll(){
        return ResponseEntity.ok(genusService.getAll());
    }
}
