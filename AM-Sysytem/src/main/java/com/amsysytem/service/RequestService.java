package com.amsysytem.service;

import com.amsysytem.dto.RequestDto;

import java.util.List;

public interface RequestService {

    List<RequestDto> getAllRequests();

//TODO  List<RequestDto> findRequestsByEmployee(EmployeeDto employeeDto); ???

//TODO  List<RequestDto> findRequestsByStatus(Status status); ???

    void save(RequestDto requestDto);

    void updateRequest(RequestDto requestDto);

    void deleteRequest(Long id);

    RequestDto getRequestDtoById(Long requestDtoId);

    List<RequestDto> findRequestsByUserId(Long id);

}
