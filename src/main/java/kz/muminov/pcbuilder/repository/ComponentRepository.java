package kz.muminov.pcbuilder.repository;

import kz.muminov.pcbuilder.model.Component;
import kz.muminov.pcbuilder.model.Manufacturer;
import kz.muminov.pcbuilder.model.dto.ManufacturerComponents;
import kz.muminov.pcbuilder.model.enums.ComponentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Long> {

    List<Component> findByManufacturerAndComponentType(Manufacturer manufacturer, ComponentType componentType);
    List<Component> findByComponentType(ComponentType componentType);

}
