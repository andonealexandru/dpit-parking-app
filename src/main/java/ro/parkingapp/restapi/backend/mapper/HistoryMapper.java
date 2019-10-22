package ro.parkingapp.restapi.backend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.parkingapp.restapi.backend.dto.HistoryDto;
import ro.parkingapp.restapi.backend.dto.PostHistoryDto;
import ro.parkingapp.restapi.backend.entity.History;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryMapper {
    @Autowired
    private ModelMapper modelMapper;

    public List<HistoryDto> convertToDto(List<History> history) {
        List<HistoryDto> historyDto = new ArrayList<HistoryDto>();
        for (History i : history)
            historyDto.add(modelMapper.map(i, HistoryDto.class));
        return historyDto;
    }

    public History convertToHistory(PostHistoryDto historyDto) {
        History history = modelMapper.map(historyDto, History.class);
        return history;
    }

    public PostHistoryDto convertToPostHistoryDto(History history) {
        PostHistoryDto postHistoryDto = modelMapper.map(history, PostHistoryDto.class);
        return postHistoryDto;
    }
}
