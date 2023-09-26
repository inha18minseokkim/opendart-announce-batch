package com.example.opendartannouncereceivebatch.DTO;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AnnounceEssentialResponse<T> {
    private String status;
    private String message;
    private List<T> list;
}
