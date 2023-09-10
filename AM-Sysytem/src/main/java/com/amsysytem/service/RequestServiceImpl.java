package com.amsysytem.service;

import com.amsysytem.dto.RequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService{

    @Override
    public List<RequestDto> getAllRequests() {
        return null;
    }

    @Override
    public void save(RequestDto requestDto) {

    }

    @Override
    public void updateRequest(RequestDto requestDto) {

    }

    @Override
    public void deleteRequest(Long id) {

    }
}
