package com.payaza.shakorouter.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.payaza.shakorouter.model.constant.ApiResponseStatus;
import com.payaza.shakorouter.model.constant.ISO8583Code;
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
public class ApiResponse {

    private boolean error = false;
    private String status = ApiResponseStatus.SUCCESSFUL.getStatus();
    private String message = "";
    private String responseCode = ISO8583Code.SUCCESSFUL.getCode();
    private Object responseData;
    private Pagination pagination; // the pagination object


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
