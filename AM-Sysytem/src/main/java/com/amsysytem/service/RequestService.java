package com.amsysytem.service;

import com.amsysytem.dto.RequestDto;

import java.util.List;

public interface RequestService {

    List<RequestDto> getAllRequests();

    List<RequestDto> findRequestsByUserId(Long id);

    List<RequestDto> findRequestsByUserEmail(String name);

    void save(RequestDto requestDto, String email);

    void updateStatus(RequestDto requestDto);

    void updateRequest(RequestDto requestDto);

    void updateRequestByManager(RequestDto requestDto);

    void deleteRequest(Long id);

    RequestDto getRequestDtoById(Long requestDtoId);

}
