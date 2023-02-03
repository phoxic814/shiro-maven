package org.example.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 簡易密碼雜湊類
 */
public class SHA256Util {

    // 算法
    public final static String HASH_ALGORITHM_NAME = "SHA-256";
    // 循環次數
    public final static int HASH_ITERATIONS = 15;

    // 加密
    public static String sha256(String password, String salt) {
        return new SimpleHash(HASH_ALGORITHM_NAME, password, salt, HASH_ITERATIONS).toString();
    }
}
