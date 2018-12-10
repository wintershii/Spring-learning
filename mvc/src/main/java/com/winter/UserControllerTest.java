package com.winter;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class UserControllerTest {

    @Test
    public void testHandle41() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String,String> form = new LinkedMultiValueMap<String, String>();
        form.add("userName","tom");
        form.add("password","123456");
        form.add("age","45");
        restTemplate.postForLocation("http://localhost:8080/user/handle41",form);
    }

    @Test
    public void testHandle42() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        byte[] response = restTemplate.postForObject("http://localhost:8080/user/handle42/{itemId}",
                null,byte[].class,"1213");
        Resource outFile = new FileSystemResource("/home/shidongxuan/111.png");
        FileCopyUtils.copy(response,outFile.getFile());
    }
}
