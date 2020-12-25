package kz.muminov.pcbuilder.service;

import kz.muminov.pcbuilder.model.Configuration;
import kz.muminov.pcbuilder.model.Manufacturer;
import kz.muminov.pcbuilder.repository.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public Configuration createConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    public Configuration updateConfiguration(Long id, Configuration configuration){

        if (!configurationRepository.existsById(id)){
            throw new RuntimeException("Configuration with id " + id + " does not exist");
        }

        Configuration updatedConfiguration = configurationRepository.findById(id).get();
        updatedConfiguration.setCpu(configuration.getCpu());
        updatedConfiguration.setGraphicsCard(configuration.getGraphicsCard());
        updatedConfiguration.setMotherBoard(configuration.getMotherBoard());
        updatedConfiguration.setPowerSupply(configuration.getPowerSupply());
        updatedConfiguration.setRam(configuration.getRam());
        updatedConfiguration.setSsd(configuration.getSsd());

        return configurationRepository.save(updatedConfiguration);

    }

    public Configuration getConfigurationById(Long id){

        if (!configurationRepository.existsById(id)){
            throw new RuntimeException("Configuration with id " + id + " does not exist");
        }

        return configurationRepository.findById(id).get();

    }

}
