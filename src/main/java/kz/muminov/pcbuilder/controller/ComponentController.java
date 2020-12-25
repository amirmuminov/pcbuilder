package kz.muminov.pcbuilder.controller;

import kz.muminov.pcbuilder.model.Component;
import kz.muminov.pcbuilder.model.Manufacturer;
import kz.muminov.pcbuilder.model.dto.ManufacturerComponents;
import kz.muminov.pcbuilder.model.enums.ComponentType;
import kz.muminov.pcbuilder.repository.ComponentRepository;
import kz.muminov.pcbuilder.repository.ManufacturerRepository;
import kz.muminov.pcbuilder.service.ComponentService;
import kz.muminov.pcbuilder.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ComponentController {

    private final ComponentService componentService;
    private final ComponentRepository componentRepository;

    private final String COMPONENT = "/component";
    private final String COMPONENT_LIST = COMPONENT + "/list";
    private final String COMPONENT_BY_ID = COMPONENT + "/{id}";
    private final String COMPONENTS_BY_MANUFACTURER_AND_COMPONENT_TYPE = COMPONENT + "/{manufacturerId}" + "/{componentType}";
    private final String COMPONENTS_BY_TYPE = COMPONENT + "/find" + "/{componentType}";

    @GetMapping(COMPONENT_LIST)
    public ResponseEntity<List<Component>> getAllManufacturers(){
        return new ResponseEntity<>(componentRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(COMPONENT)
    public ResponseEntity<Component> createManufacturer(@RequestBody Component component){
        return new ResponseEntity<>(componentService.createComponent(component), HttpStatus.CREATED);
    }

    @GetMapping(COMPONENT_BY_ID)
    public ResponseEntity<Component> getAllManufacturers(@PathVariable Long id){
        return new ResponseEntity<>(componentService.getComponentById(id), HttpStatus.OK);
    }

    @GetMapping(COMPONENTS_BY_MANUFACTURER_AND_COMPONENT_TYPE)
    public ResponseEntity<ManufacturerComponents> getComponentsByManufacturerAndType(@PathVariable Long manufacturerId, @PathVariable ComponentType componentType){
            return new ResponseEntity<>(componentService.getComponentsByManufacturerAndType(manufacturerId, componentType), HttpStatus.OK);
    }

    @GetMapping(COMPONENTS_BY_TYPE)
    public ResponseEntity<List<Component>> getComponentsByType(@PathVariable ComponentType componentType){
        return new ResponseEntity<>(componentService.getComponentsByType(componentType), HttpStatus.OK);
    }


}
