package com.amsysytem.service;

import com.amsysytem.dto.RequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {

    List<RequestDto> getAllRequests();

    void save(RequestDto requestDto);

    void updateRequest(RequestDto requestDto);

    void deleteRequest(Long id);
}
