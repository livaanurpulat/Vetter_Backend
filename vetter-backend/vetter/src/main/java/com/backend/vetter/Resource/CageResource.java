package com.backend.vetter.Resource;

import com.backend.vetter.DTO.CageDTO;
import com.backend.vetter.Service.CageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetter-api")
public class CageResource {

    @Autowired
    CageService cageService;

    @GetMapping("/cage-delete/{id}")
    public ResponseEntity<Boolean> cageDelete(@PathVariable("id") Long id){
        return ResponseEntity.ok(cageService.delete(id));
    }

    @PostMapping("/cage-add")
    public ResponseEntity<CageDTO> cageAdd(@RequestBody CageDTO cageDTO){
        return ResponseEntity.ok(cageService.add(cageDTO));
    }

    @GetMapping("/cage-get-all")
    public ResponseEntity<List<CageDTO>> cageGetAll(){
        return ResponseEntity.ok(cageService.getAll());
    }
}
