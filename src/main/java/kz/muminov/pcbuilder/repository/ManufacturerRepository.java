package kz.muminov.pcbuilder.repository;

import kz.muminov.pcbuilder.model.Manufacturer;
import kz.muminov.pcbuilder.model.dto.ManufacturerComponents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

}
