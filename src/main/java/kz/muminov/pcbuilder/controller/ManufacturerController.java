package kz.muminov.pcbuilder.controller;

import kz.muminov.pcbuilder.model.Manufacturer;
import kz.muminov.pcbuilder.repository.ManufacturerRepository;
import kz.muminov.pcbuilder.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;
    private final ManufacturerRepository manufacturerRepository;

    private final String MANUFACTURER = "/manufacturer";
    private final String MANUFACTURER_LIST = MANUFACTURER + "/list";
    private final String MANUFACTURER_BY_ID = MANUFACTURER + "/{id}";

    @GetMapping(MANUFACTURER_LIST)
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(){
        return new ResponseEntity<>(manufacturerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(MANUFACTURER)
    public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer){
        return new ResponseEntity<>(manufacturerService.createManufacturer(manufacturer), HttpStatus.CREATED);
    }

    @GetMapping(MANUFACTURER_BY_ID)
    public ResponseEntity<Manufacturer> getAllManufacturers(@PathVariable Long id){
        return new ResponseEntity<>(manufacturerService.getManufacturerById(id), HttpStatus.OK);
    }

}
