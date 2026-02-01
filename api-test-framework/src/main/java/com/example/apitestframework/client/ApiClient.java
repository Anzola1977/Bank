package com.example.apitestframework.client;

import com.example.apitestframework.config.XmlMapperProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiClient.class);

    private final XmlMapper xmlMapper;
    private final RequestSpecification requestSpecification;

    public ApiClient(String baseUri) {
        this.xmlMapper = XmlMapperProvider.get();
        this.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .addHeader("Content-Type", "application/xml")
                .addHeader("Accept", "application/xml")
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public String serialize(Object payload) throws JsonProcessingException {
        String xml = xmlMapper.writeValueAsString(payload);
        LOGGER.info("Serialized payload to XML: {}", xml);
        return xml;
    }

    public <T> T deserialize(String xml, Class<T> target) throws JsonProcessingException {
        LOGGER.info("Deserializing XML: {}", xml);
        return xmlMapper.readValue(xml, target);
    }
}
