package com.backend.vetter.Resource;

import com.backend.vetter.DTO.TreatmentDTO;
import com.backend.vetter.Service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetter-api")
public class TreatmentResource {

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/treatment-delete/{id}")
    public ResponseEntity<Boolean>treatmentDelete(@PathVariable("id") Long id){
        return ResponseEntity.ok(treatmentService.delete(id));
    }

    @PostMapping("/treatment-add")
    public ResponseEntity<TreatmentDTO>treatmentAdd(@RequestBody TreatmentDTO treatmentDTO){
        return ResponseEntity.ok(treatmentService.add(treatmentDTO));
    }

    @GetMapping("/treatment-get-all")
    public ResponseEntity<List<TreatmentDTO>>treatmentGetAll(){
        return ResponseEntity.ok(treatmentService.getAll());
    }
}
