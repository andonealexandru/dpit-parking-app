package ro.parkingapp.restapi.backend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.parkingapp.restapi.backend.dto.ParkCoordinatesDto;
import ro.parkingapp.restapi.backend.dto.ParkingCreateDto;
import ro.parkingapp.restapi.backend.dto.ParkingGetDto;
import ro.parkingapp.restapi.backend.dto.PostParkingDto;
import ro.parkingapp.restapi.backend.entity.ParkingLot;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParkingMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ParkingLot convertToParkingLot(ParkingCreateDto parkingCreateDto) {
        ParkingLot parkingLot = modelMapper.map(parkingCreateDto, ParkingLot.class);
        return parkingLot;
    }

    public ParkingCreateDto convertToParkingDto(ParkingLot parkingLot) {
        ParkingCreateDto parkingLotDto = modelMapper.map(parkingLot, ParkingCreateDto.class);
        return parkingLotDto;
    }

    public List<ParkCoordinatesDto> convertToParkingListDto(List<ParkingLot> parkingLots) {
        List<ParkCoordinatesDto> parkCoordinatesDtos = new ArrayList<>();

        for (ParkingLot i : parkingLots) {
            parkCoordinatesDtos.add(modelMapper.map(i, ParkCoordinatesDto.class));
        }

        return parkCoordinatesDtos;
    }

    public ParkingGetDto convertToParkingGetDto(ParkingLot parkingLot) {
        ParkingGetDto parkingLotDto = modelMapper.map(parkingLot, ParkingGetDto.class);
        return parkingLotDto;
    }

    public ParkingLot convertToPostParkingDto(PostParkingDto postParkingDto) {
        ParkingLot parkingLot = modelMapper.map(postParkingDto, ParkingLot.class);
        return parkingLot;
    }
}
