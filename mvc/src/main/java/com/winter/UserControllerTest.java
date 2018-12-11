package com.winter;

import com.winter.domain.User;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

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

    @Test
    public void testHandle51() {
        RestTemplate template = new RestTemplate();

        User user = new User();
        user.setUserName("shidongxuan");
        user.setPassword("123123");

        HttpHeaders entityHeaders = new HttpHeaders();
        entityHeaders.setContentType(MediaType.valueOf("application/json;UTF-8"));
        entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> requestEntity = new HttpEntity<User>(user,entityHeaders);

        ResponseEntity<User> responseEntity = template.exchange(
                "http://localhost:8080/user/handle51",
                HttpMethod.POST,requestEntity,User.class
        );

        User responseUser = responseEntity.getBody();
        System.out.println(responseUser);


    }
}
