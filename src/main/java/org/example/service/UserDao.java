package org.example.service;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDao implements Serializable {

    private String userName;
    private String passWord;
    private String salt;

    public static final String ADMIN = "admin";
    public static final String USER = "user";

    public static UserDao adminUser() {
        return UserDao.builder()
                .userName("admin")
                .passWord("a1bb09ad5dea12e0f94762cb116c447e80c784d8aa2c6625263f7f3436cdd583")
                .salt("RvP3UID2n30Q2sycZYvH")
                .build();
    }

    public static UserDao normalUser() {
        return UserDao.builder()
                .userName("user")
                .passWord("376eb5d2698c804ee83594fe8b0217f03ad138a046f7fa42b44c232c2e5e2b38")
                .salt("OVlrD37bDUKNcFRB10qG")
                .build();
    }
}
