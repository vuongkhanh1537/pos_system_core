package com.longhuei.pos_system_core.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PageResponse<T> {
    private int pageIndex;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private List<T> data;

    public PageResponse(Page<T> data) {
        this.data = data.getContent();
        this.pageIndex = data.getPageable().getPageNumber();
        this.pageSize = data.getPageable().getPageSize();
        this.totalPages = data.getTotalPages();
        this.totalElements = data.getTotalElements();
    }
    
}
