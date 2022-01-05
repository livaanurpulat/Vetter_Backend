package com.backend.vetter.Resource;

import com.backend.vetter.DTO.ConsultationDTO;
import com.backend.vetter.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetter-api")
public class ConsultationResource {

    @Autowired
    ConsultationService consultationService;

    @GetMapping("/consultation-delete/{id}")
    public ResponseEntity<Boolean> consultationDelete (@PathVariable("id")Long id){
        return ResponseEntity.ok(consultationService.delete(id));
    }
    @PostMapping("/consultation-add")
    public ResponseEntity<ConsultationDTO> consultationAdd (@RequestBody ConsultationDTO consultationDTO){
        return  ResponseEntity.ok(consultationService.add(consultationDTO));
    }
    @GetMapping("/consultation-get-all")
    public ResponseEntity<List<ConsultationDTO>> consultationGetAll(){
        return  ResponseEntity.ok(consultationService.getAll());
    }
}
