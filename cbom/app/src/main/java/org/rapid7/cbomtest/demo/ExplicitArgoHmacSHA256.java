package com.rapid7.cbomtest.demo;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ExplicitArgoHmacSHA256 {
    public static void main(String[] args) {
        try {
            String data = "Hello, World!";
            byte[] key = "my-secret-key".getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA256");
            
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);

            byte[] hmacBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

            String hmac = Base64.getEncoder().encodeToString(hmacBytes);

            System.out.println("Data: " + data);
            System.out.println("HMAC-SHA256: " + hmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}