package com.romanpulov.violetnotews.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestExceptionResponse {
    private final int code;
    private final String message;

    public RestExceptionResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @XmlElement
    @JsonProperty("errorCode")
    public int getCode() {
        return this.code;
    }

    @XmlElement
    @JsonProperty("errorMessage")
    public String getMessage() {
        return this.message;
    }
}
