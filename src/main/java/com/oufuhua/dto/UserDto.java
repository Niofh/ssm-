package com.oufuhua.dto;

import com.oufuhua.model.User;
import org.springframework.web.multipart.MultipartFile;

public class UserDto extends User {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
