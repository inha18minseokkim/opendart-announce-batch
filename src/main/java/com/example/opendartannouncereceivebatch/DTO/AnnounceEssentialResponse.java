package com.example.opendartannouncereceivebatch.DTO;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@ToString
public class AnnounceEssentialResponse {
    private String status;
    private String message;
    private List<Object> list;
}
