package com.example.opendartannouncereceivebatch.DTO;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@ToString
public class AnnounceDefaultResponse implements Serializable {
    private String status;
    private String message;
    private String page_no;
    private Integer page_count;
    private Integer total_count;
    private Integer total_page;
    private List<AnnounceDefaultElement> list;
}
