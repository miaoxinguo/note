package io.github.miaoxinguo.common.util;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * 散列工具类
 */
public final class HashUtils {

    private static final String HASH_ALG_SHA1 = "SHA1";
    private static final String HASH_ALG_MD5 = "MD5";
    private static final String HASH_ALG_HMACSHA1 = "HmacSHA1";
    
    private HashUtils() {
    }

    /**
     * MD5 Base64格式
     * 
     * @param text 明文
     * @return Base64散列字符串
     */
    public static String md5Base64(String text) {
        return Base64.getEncoder().encodeToString(hash(text, HASH_ALG_MD5));
    }

    /**
     * MD5 十六进制格式
     *
     * @param text 明文
     * @return 散列值的十六进制小写格式
     */
    public static String md5Hex(String text) {
        return Hex.encodeHexString(hash(text, HASH_ALG_MD5));
    }

    /**
     * SHA1 Base64格式
     *
     * @param text 明文
     * @return Base64散列字符串
     */
    public static String sha1Base64(String text) {
        return Base64.getEncoder().encodeToString(hash(text, HASH_ALG_SHA1));
    }

    /**
     * SHA1 十六进制格式
     * 
     * @param text 明文
     * @return 散列值的十六进制小写格式
     */
    public static String sha1Hex(String text) {
        return Hex.encodeHexString(hash(text, HASH_ALG_SHA1));
    }

    /**
     * 散列运算
     * 
     * @param text 明文
     * @param alg 算法 
     * @return 散列字符串
     */
    private static byte[] hash(String text, String alg) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(alg);
        } catch (NoSuchAlgorithmException e) {
            // ignore
        }
        return md == null ? new byte[0] : md.digest(text.getBytes());
    }

    /**
     * HmacSHA1 Base64格式
     *
     * @param text 明文
     * @param key 对称密钥
     * @return 散列值的十六进制小写格式
     */
    public static String hmacSha1Base64(String text, String key) throws InvalidKeyException {
        return Base64.getEncoder().encodeToString(hmac(text, key, HASH_ALG_HMACSHA1));
    }

    /**
     * Mac运算
     *
     * @param text 明文
     * @param key 对称密钥
     * @param alg 算法
     * @return 散列字符串
     */
    private static byte[] hmac(String text, String key, String alg) throws InvalidKeyException {
        Mac mac = null;
        try {
            mac = Mac.getInstance(alg);
            mac.init(new SecretKeySpec(key.getBytes(), mac.getAlgorithm()));
        } catch (NoSuchAlgorithmException e) {
            // ignore
        }
        return mac != null ? mac.doFinal(text.getBytes()) : new byte[0];
    }
}
