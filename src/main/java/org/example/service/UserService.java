package org.example.service;

import org.apache.catalina.User;
import org.example.util.SHA256Util;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 簡易user服務類, 模擬db操作
 */
@Service
public class UserService {

    private static int RANDOM_LENGTH = 20;

    private static ConcurrentHashMap<String, UserDao> map = new ConcurrentHashMap<>();

    static {
        map.put(UserDao.ADMIN, UserDao.adminUser());
        map.put(UserDao.USER, UserDao.normalUser());
    }
    public UserDao findUser(String userName) {
        return map.get(userName);
    }

    public synchronized void addUser(String name, String pass) {
        if (map.containsKey(name)) {
            throw new IllegalArgumentException("user exists");
        }

        // 亂數取salt, 限制英文+數字
        Random random = new Random();
        String salt = random.ints(48, 123)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(20).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        map.put(name, UserDao.builder()
                .userName(name)
                .passWord(SHA256Util.sha256(pass, salt))
                .salt(salt)
                .build());
    }

}
