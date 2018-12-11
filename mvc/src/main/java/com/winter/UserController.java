package com.winter;

import com.winter.domain.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "/handle41")
    public String handle41(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    @ResponseBody
    @RequestMapping(path = "/handle42/{imageId}")
    public byte[] handle42(@PathVariable("imageId") String imageId) throws IOException {
        System.out.println("load image of" + imageId);
        Resource res = new ClassPathResource("image.png");
        byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
        return fileData;
    }

    @RequestMapping(path = "/handle51")
    public ResponseEntity<User> handle51(HttpEntity<User> requestEntity) {
        User user = requestEntity.getBody();
        user.setUserId(1000);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
