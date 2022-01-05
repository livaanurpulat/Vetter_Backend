package com.backend.vetter.Resource;

import com.backend.vetter.DTO.CustomerDTO;
import com.backend.vetter.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CustomerResource {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer-delete/{id}")
    public ResponseEntity<Boolean> customerDelete (@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.delete(id));
    }

    @PostMapping("/customer-add")
    public ResponseEntity<CustomerDTO> customerAdd (@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(customerService.add(customerDTO));
    }

    @GetMapping("/customer-get-all")
    public ResponseEntity<List<CustomerDTO>> customerGetAll (){
        return ResponseEntity.ok(customerService.getAll());
    }
}

