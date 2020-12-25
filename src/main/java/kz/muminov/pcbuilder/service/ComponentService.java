package kz.muminov.pcbuilder.service;

import kz.muminov.pcbuilder.model.Component;
import kz.muminov.pcbuilder.model.Manufacturer;
import kz.muminov.pcbuilder.model.dto.ManufacturerComponents;
import kz.muminov.pcbuilder.model.enums.ComponentType;
import kz.muminov.pcbuilder.repository.ComponentRepository;
import kz.muminov.pcbuilder.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComponentService {

    private final ComponentRepository componentRepository;
    private final ManufacturerRepository manufacturerRepository;

    public Component createComponent(Component component){
        return componentRepository.save(component);
    }

    public Component getComponentById(Long id){

        if (!componentRepository.existsById(id)){
            throw new RuntimeException("Component with id " + id + " does not exist");
        }

        return componentRepository.findById(id).get();

    }

    public ManufacturerComponents getComponentsByManufacturerAndType(Long manufacturerId, ComponentType componentType){

        if (!manufacturerRepository.existsById(manufacturerId)){
            throw new RuntimeException("Manufacturer with id " + manufacturerId + " does not exist");
        }

        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).get();

        ManufacturerComponents manufacturerComponents = new ManufacturerComponents();
        manufacturerComponents.setComponents(componentRepository.findByManufacturerAndComponentType(manufacturer, componentType));

        return manufacturerComponents;

    }

    public List<Component> getComponentsByType(ComponentType componentType){

        return componentRepository.findByComponentType(componentType);

    }

}
