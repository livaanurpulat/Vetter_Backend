package com.backend.vetter.Resource;

import com.backend.vetter.DTO.VaccinationDTO;
import com.backend.vetter.Entity.Vaccination;
import com.backend.vetter.Service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetter-api")
public class VaccinationResource {

    @Autowired
    VaccinationService vaccinationService;

    @GetMapping("/vaccination-delete/{id}")
    public ResponseEntity<Boolean>vaccinationDelete(@PathVariable("id") Long id){
        return ResponseEntity.ok(vaccinationService.delete(id));
    }

    @PostMapping("/vaccination-add")
    public ResponseEntity<VaccinationDTO>vaccinationAdd(@RequestBody VaccinationDTO vaccinationDTO){
        return ResponseEntity.ok(vaccinationService.add(vaccinationDTO));
    }

    @GetMapping("/vaccination-get-all")
    public ResponseEntity<List<VaccinationDTO>>vaccinationGetAll(){
        return ResponseEntity.ok(vaccinationService.getAll());
    }

}
