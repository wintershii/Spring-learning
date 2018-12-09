package com.winter;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class UserControllerTest {

    @Test
    public void testHandle41() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String,String> form = new LinkedMultiValueMap<String, String>();
        form.add("userName","tom");
        form.add("password","123456");
        form.add("age","45");
        restTemplate.postForLocation("http://localhost:8080/mvc/user/handle41.html",form);
    }
}
