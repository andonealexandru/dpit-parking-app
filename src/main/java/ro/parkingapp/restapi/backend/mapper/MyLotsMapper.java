package ro.parkingapp.restapi.backend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.parkingapp.restapi.backend.dto.MyLotsDto;
import ro.parkingapp.restapi.backend.entity.ParkingLot;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyLotsMapper {
    @Autowired
    private ModelMapper modelMapper;

    public List<MyLotsDto> convertToDto(List<ParkingLot> parkingLot) {
        List<MyLotsDto> myLotsDto = new ArrayList<>();
        for (ParkingLot i : parkingLot)
            myLotsDto.add(modelMapper.map(i, MyLotsDto.class));
        return myLotsDto;
    }
}
