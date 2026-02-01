package com.example.apitestframework;

import com.example.apitestframework.client.ApiClient;
import com.example.apitestframework.model.UserRequest;
import com.example.apitestframework.model.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiFrameworkTest {
    @Test
    void serializesRequestToXml() throws JsonProcessingException {
        ApiClient apiClient = new ApiClient("https://api.example.test");
        UserRequest request = UserRequest.builder()
                .id("123")
                .name("Ada")
                .email("ada@example.test")
                .build();

        String xml = apiClient.serialize(request);

        assertThat(xml)
                .contains("<userRequest>")
                .contains("<id>123</id>")
                .contains("<name>Ada</name>")
                .contains("<email>ada@example.test</email>");
    }

    @Test
    void deserializesResponseFromXml() throws JsonProcessingException {
        ApiClient apiClient = new ApiClient("https://api.example.test");
        String xml = """
                <?xml version=\"1.0\" encoding=\"UTF-8\"?>
                <userResponse>
                    <status>OK</status>
                    <message>Created</message>
                    <requestId>req-42</requestId>
                </userResponse>
                """;

        UserResponse response = apiClient.deserialize(xml, UserResponse.class);

        assertThat(response.getStatus()).isEqualTo("OK");
        assertThat(response.getMessage()).isEqualTo("Created");
        assertThat(response.getRequestId()).isEqualTo("req-42");
    }

    @Test
    void buildsRequestSpecification() {
        ApiClient apiClient = new ApiClient("https://api.example.test");

        RequestSpecification specification = apiClient.getRequestSpecification();

        assertThat(specification.getBaseUri()).isEqualTo("https://api.example.test");
        assertThat(specification.getHeaders().getValue("Content-Type"))
                .isEqualTo("application/xml");
        assertThat(specification.getHeaders().getValue("Accept"))
                .isEqualTo("application/xml");
    }
}
