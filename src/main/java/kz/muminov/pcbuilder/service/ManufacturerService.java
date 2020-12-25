package kz.muminov.pcbuilder.service;

import kz.muminov.pcbuilder.model.Manufacturer;
import kz.muminov.pcbuilder.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public Manufacturer createManufacturer(Manufacturer manufacturer){
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer getManufacturerById(Long id){

        if (!manufacturerRepository.existsById(id)){
            throw new RuntimeException("Manufacturer with id " + id + " does not exist");
        }

        return manufacturerRepository.findById(id).get();

    }

}
