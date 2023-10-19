package com.amsysytem.service;

import com.amsysytem.dto.RequestDto;
import com.amsysytem.entity.Request;
import com.amsysytem.mappers.RequestMapper;
import com.amsysytem.repositories.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {

    public final RequestRepository requestRepository;

    @Override
    public List<RequestDto> getAllRequests() {
        List<Request> requests = requestRepository.findAll();
        List<RequestDto> requestDtos = requests.stream()
                .map((request) -> RequestMapper.mapToRequestDto(request))
                .collect(Collectors.toList());
        return requestDtos;
    }

    @Override
    public void save(RequestDto requestDto) {
        requestRepository.save(RequestMapper.mapToRequest(requestDto));
    }

    @Override
    public void updateRequest(RequestDto requestDto) {
        requestRepository.save(RequestMapper.mapToRequest(requestDto));
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }

    @Override
    public RequestDto getRequestDtoById(Long requestDtoId) {
        Optional<Request> tempRequest = requestRepository.findById(requestDtoId);

        Request request;
        if (tempRequest.isPresent()) {
            request = tempRequest.get();
        } else {
            throw new RuntimeException("There is no request for id: " + requestDtoId);
        }
        return RequestMapper.mapToRequestDto(request);
    }
}






















