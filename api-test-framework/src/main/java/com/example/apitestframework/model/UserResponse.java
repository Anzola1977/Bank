package com.example.apitestframework.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "userResponse")
public class UserResponse {
    @JacksonXmlProperty(localName = "status")
    private String status;

    @JacksonXmlProperty(localName = "message")
    private String message;

    @JacksonXmlProperty(localName = "requestId")
    private String requestId;
}
