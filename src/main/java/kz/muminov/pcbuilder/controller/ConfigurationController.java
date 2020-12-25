package kz.muminov.pcbuilder.controller;

import kz.muminov.pcbuilder.model.Configuration;
import kz.muminov.pcbuilder.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationService configurationService;

    private final String CONFIGURATION = "/configuration";
    private final String CONFIGURATION_BY_ID = CONFIGURATION + "/{id}";
    private final String CONFIGURATION_UPDATE = CONFIGURATION + "/update/{id}";

    @PostMapping(CONFIGURATION)
    public ResponseEntity<Configuration> createConfiguration(@RequestBody Configuration configuration){
        return new ResponseEntity<>(configurationService.createConfiguration(configuration), HttpStatus.CREATED);
    }

    @PutMapping(CONFIGURATION_UPDATE)
    public ResponseEntity<Configuration> createConfiguration(@PathVariable Long id, @RequestBody Configuration configuration){
        return new ResponseEntity<>(configurationService.updateConfiguration(id, configuration), HttpStatus.CREATED);
    }

    @GetMapping(CONFIGURATION_BY_ID)
    public ResponseEntity<Configuration> getConfigurationByid(@PathVariable Long id){
        return new ResponseEntity<>(configurationService.getConfigurationById(id), HttpStatus.OK);
    }

}
