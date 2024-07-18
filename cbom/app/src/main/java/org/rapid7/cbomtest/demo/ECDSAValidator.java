package com.rapid7.cbomtest.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class ECDSAValidator {
    public static void main(String[] args) {
        try {
            byte[] publicKeyBytes = Files.readAllBytes(Paths.get("resources", "ecdsa_256.pub"));
            byte[] decodedPublicKey = Base64.getDecoder().decode(publicKeyBytes);

            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedPublicKey);
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            validatePublicKey(publicKey);

            System.out.println("ECDSA public key is valid.");
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException e) {
            System.err.println("Error validating ECDSA public key: " + e.getMessage());
        }
    }

    private static void validatePublicKey(PublicKey publicKey) throws InvalidKeyException {
        if (!"EC".equals(publicKey.getAlgorithm())) {
            throw new InvalidKeyException("Invalid key algorithm. Expected EC.");
        }
    }
}