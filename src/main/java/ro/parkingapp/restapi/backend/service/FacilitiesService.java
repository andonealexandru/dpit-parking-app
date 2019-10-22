package ro.parkingapp.restapi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import ro.parkingapp.restapi.backend.dto.FacilitiesDto;
import ro.parkingapp.restapi.backend.entity.Facilities;
import ro.parkingapp.restapi.backend.mapper.FacilitiesMapper;
import ro.parkingapp.restapi.backend.repository.FacilitiesRepository;

import java.util.List;

@Configurable
@Service
public class FacilitiesService {

    @Autowired
    private FacilitiesMapper facilitiesMapper;
    @Autowired
    private FacilitiesRepository facilitiesRepository;

    public List<Facilities> findFacilities() {
        return (List<Facilities>) facilitiesRepository.findAll();
    }

    public List<FacilitiesDto> getFacilities(List<Facilities> facilities) {
        List<FacilitiesDto> facilitiesDto = facilitiesMapper.convertToFacilitiesDto(facilities);
        return facilitiesDto;
    }


}
