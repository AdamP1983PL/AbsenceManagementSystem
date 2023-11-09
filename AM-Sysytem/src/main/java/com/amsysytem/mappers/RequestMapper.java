package com.amsysytem.mappers;

import com.amsysytem.dto.RequestDto;
import com.amsysytem.entity.Request;

public class RequestMapper {

    public static RequestDto mapToRequestDto(Request request) {
        return new RequestDto(
                request.getId(),
                request.getLastName(),
                request.getFirstName(),
                request.getEmail(),
                request.getDateTimeCreated(),
                request.getStartingDate(),
                request.getEndingDate(),
                request.getDaysCount(),
//                request.getDueDays(),
                request.getStatus(),
                request.getEmployee()
        );
    }

    public static Request mapToRequest(RequestDto requestDto) {
        return new Request(
                requestDto.getId(),
                requestDto.getLastName(),
                requestDto.getFirstName(),
                requestDto.getEmail(),
                requestDto.getDateTimeCreated(),
                requestDto.getStartingDate(),
                requestDto.getEndingDate(),
                requestDto.getDaysCount(),
//                requestDto.getDueDays(),
                requestDto.getStatus(),
                requestDto.getEmployee()
        );
    }
}
