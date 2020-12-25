package kz.muminov.pcbuilder.model.dto;

import kz.muminov.pcbuilder.model.Component;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ManufacturerComponents {

    private List<Component> components;

}
