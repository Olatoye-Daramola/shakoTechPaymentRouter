package com.payaza.shakorouter.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Pagination {

    private int pageSize;

    private int pageNumber;

    private int totalPages;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
