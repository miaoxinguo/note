package io.github.miaoxinguo.common.util;

import java.security.InvalidKeyException;

import org.junit.Test;

/**
 *
 */
public class TestHashUtils {

    @Test
    public void testHash(){
        String s = "i am plain text";
        System.out.println(HashUtils.md5Hex(s));
        System.out.println(HashUtils.md5Base64(s));
        System.out.println(HashUtils.sha1Hex(s));
        System.out.println(HashUtils.sha1Base64(s));
    }

    @Test
    public void testMac() throws InvalidKeyException {
        String plainText = "i am plain text";
        String key = "12345678";
        System.out.println(HashUtils.hmacSha1Base64(plainText, key));
    }
}
