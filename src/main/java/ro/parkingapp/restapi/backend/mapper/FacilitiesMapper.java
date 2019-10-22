package ro.parkingapp.restapi.backend.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.parkingapp.restapi.backend.dto.FacilitiesDto;
import ro.parkingapp.restapi.backend.entity.Facilities;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacilitiesMapper {
    @Autowired
    private ModelMapper modelMapper;

    public List<Facilities> convertToFacilities(List<FacilitiesDto> facilitiesDto) {
        List<Facilities> facilities = new ArrayList<Facilities>();
        for (FacilitiesDto i : facilitiesDto) {
            facilities.add(modelMapper.map(i, Facilities.class));
        }
        return facilities;
    }

    public List<FacilitiesDto> convertToFacilitiesDto(List<Facilities> facilities) {
        List<FacilitiesDto> facilitiesDto = new ArrayList<FacilitiesDto>();
        for (Facilities i : facilities)
            facilitiesDto.add(modelMapper.map(i, FacilitiesDto.class));
        return facilitiesDto;
    }

}
