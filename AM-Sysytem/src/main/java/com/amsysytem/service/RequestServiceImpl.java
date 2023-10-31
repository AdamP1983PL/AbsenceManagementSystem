package com.amsysytem.service;

import com.amsysytem.dto.RequestDto;
import com.amsysytem.entity.Employee;
import com.amsysytem.entity.Request;
import com.amsysytem.entity.User;
import com.amsysytem.mappers.RequestMapper;
import com.amsysytem.repositories.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

        return requests.stream()
                .map(RequestMapper::mapToRequestDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RequestDto> findRequestsByUserId(Long id) {
        Optional<Request> requestsByUserId = requestRepository.findById(id);

        return requestsByUserId.stream()
                .map(RequestMapper::mapToRequestDto)
                .collect(Collectors.toList());
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






















