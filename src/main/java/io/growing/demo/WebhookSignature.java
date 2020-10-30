package io.growing.demo;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

/**
 * 计算webhook签名,用整个请求体作为参数.
 */
public class WebhookSignature {
    static String sign(String requestBody, String secret) {
        return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secret).hmacHex(requestBody);
    }

    public static void main(String[] args) {
        String secret = "a1234567";
        String body = "{\"name\":\"TEST2\",\"userAttr\":[],\"templateParam\":{\"title\":\"这是标题！！1\",\"content\":\"这是内容！！2\"},\"timestamp\":\"2020-10-28T03:19:31.269Z\"}";
        String res = sign(body, secret);
        System.out.println(res);
    }
}
