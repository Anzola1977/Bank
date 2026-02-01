package com.example.apitestframework.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public final class XmlMapperProvider {
    private static final XmlMapper XML_MAPPER = XmlMapper.builder()
            .defaultUseWrapper(false)
            .configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true)
            .build();

    private XmlMapperProvider() {
    }

    public static XmlMapper get() {
        return XML_MAPPER;
    }
}
