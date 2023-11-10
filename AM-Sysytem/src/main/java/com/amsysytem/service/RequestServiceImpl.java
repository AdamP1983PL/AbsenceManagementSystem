package com.amsysytem.service;

import com.amsysytem.dto.EmployeeDto;
import com.amsysytem.dto.RequestDto;
import com.amsysytem.entity.Employee;
import com.amsysytem.entity.Request;
import com.amsysytem.enums.Status;
import com.amsysytem.mappers.RequestMapper;
import com.amsysytem.repositories.RequestRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {

    public final RequestRepository requestRepository;
    public final EmployeeServiceImpl employeeServiceImpl;

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
    public void save(RequestDto requestDto, String email) {
        EmployeeDto employee = employeeServiceImpl.findByEmail(email);
        requestDto.setLastName(employee.getLastName());
        requestDto.setFirstName(employee.getFirstName());
        requestDto.setEmail(employee.getEmail());
        requestDto.setStatus(Status.PENDING);
        requestRepository.save(RequestMapper.mapToRequest(requestDto));
    }

    @Override
    public void updateStatus(RequestDto requestDto) {
        requestRepository.save(RequestMapper.mapToRequest(requestDto));
    }

    @Override
    public void updateRequest(RequestDto requestDto) {
//         todo here
        Request request = requestRepository.findById(requestDto.getId())
                        .orElseThrow(() -> new EntityNotFoundException("There is no Request for id: " + requestDto.getId()));
        requestDto.setFirstName(requestDto.getFirstName());
        requestDto.setLastName(requestDto.getLastName());
        requestDto.setEmail(request.getEmail());
        requestDto.setStatus(Status.PENDING);
        requestRepository.save(RequestMapper.mapToRequest(requestDto));
    }

    @Override
    public void updateRequestByManager(RequestDto requestDto) {
//         todo here
        Request request = requestRepository.findById(requestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("There is no Request for id: " + requestDto.getId()));
        requestDto.setFirstName(requestDto.getFirstName());
        requestDto.setLastName(requestDto.getLastName());
        requestDto.setEmail(request.getEmail());
        requestDto.setDateTimeCreated(request.getDateTimeCreated());
        requestDto.setStartingDate(request.getStartingDate());
        requestDto.setEndingDate(request.getEndingDate());
        requestDto.setStatus(requestDto.getStatus());
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

    public List<RequestDto> findRequestsByUserEmail(String name) {
        List<Request> requests = requestRepository.findAllByEmail(name);
        return requests.stream()
                .map(RequestMapper::mapToRequestDto)
                .toList();
    }

    public List<RequestDto> findRequestsByEmployeeId(Long employeeId) {
        List<Request> requests = requestRepository.findAllByEmployeeId(employeeId);
        return requests.stream()
                .map(RequestMapper::mapToRequestDto)
                .toList();
    }


}






















