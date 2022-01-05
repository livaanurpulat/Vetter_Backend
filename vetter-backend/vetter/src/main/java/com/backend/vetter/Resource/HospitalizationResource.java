package com.backend.vetter.Resource;

import com.backend.vetter.DTO.HospitalizationDTO;
import com.backend.vetter.Service.HospitalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetter-api")
public class HospitalizationResource {

    @Autowired
    HospitalizationService hospitalizationService;

    @GetMapping("/hospitalization-delete/{id}")
    public ResponseEntity<Boolean> hospitalizationDelete (@PathVariable("id") Long id){
        return ResponseEntity.ok(hospitalizationService.delete(id));
    }
    @PostMapping("/hospitalization-add")
    public ResponseEntity<HospitalizationDTO> hospitalizationAdd (@RequestBody HospitalizationDTO hospitalizationDTO){
        return ResponseEntity.ok(hospitalizationService.add(hospitalizationDTO));
    }
    @GetMapping("/hospitalization-get-all")
    public ResponseEntity<List<HospitalizationDTO>> hospitalizationGetAll(){
        return ResponseEntity.ok(hospitalizationService.getAll());
    }
}
