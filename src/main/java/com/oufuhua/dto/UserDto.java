package com.oufuhua.dto;

import com.oufuhua.model.User;
import org.springframework.web.multipart.MultipartFile;

public class UserDto extends User {

    private static final long serialVersionUID = 4698569412709213671L;

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
