package com.example.mybatisplusissue1061.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * 加密工具类
 */
public class EncryptionUtils {
    /**
     * 计算Hash+salt
     * @param data
     * @param salt
     * @return
     */
    public static String sha256Hex(String data, String salt) {
        if (StringUtils.isEmpty(salt)){
            return DigestUtils.sha256Hex(data);
        } else {
            return DigestUtils.sha256Hex(data + ":" + salt);
        }
    }

    public static String base64Encode(String data) {
        return Base64.encodeBase64String(data.getBytes());
    }

    public static String base64Encode(byte[] data) {
        return Base64.encodeBase64String(data);
    }

    public static String base64Decode(String base64Str) {
        byte[] bytes = Base64.decodeBase64(base64Str);
        return new String(bytes);
    }

    /**
     * 获取随机数
     * @param count
     * @return
     */
    public static String Random(int count) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
