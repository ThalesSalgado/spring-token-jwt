package com.tjds.jwt.tokenjwt.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.StringJoiner;

@Component
@Profile("!test")
public class CryptHelper {

    /*private static final String AES_ALGORITHM = "AES";
    private static final String CHAR_SEQUENCE = "<<>>";

    private Key key;

    @Value("${ldap_key}")
    private String sKey;

    @PostConstruct
    private void init() throws Exception {
        try {
            byte[] byteKey = Base64.getDecoder().decode(sKey);
            key = new SecretKeySpec(byteKey, 0, byteKey.length, AES_ALGORITHM);
        } catch (Exception e) {
            throw new Exception("Error to generate cryptography key.", e);
        }
    }

    private String addIVInMessage(IvParameterSpec iv, byte[] byteCipherText) {
        if (iv == null) {
            return HexBytesTranslator.toHex(byteCipherText);
        }

        return HexBytesTranslator.toHex(iv.getIV()) + CHAR_SEQUENCE + HexBytesTranslator.toHex(byteCipherText);
    }

    private IvParameterSpec buildIV() {
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[16];
        random.nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    private Key getKey() {
        return key;
    }

    private Cipher getCipherInstance() throws Exception {
        StringJoiner sj = new StringJoiner("/");
        sj.add(AES_ALGORITHM).add("CBC").add("PKCS5Padding").toString();

        return Cipher.getInstance(sj.toString());
    }

    public String encrypt(String pureText) throws Exception {
        try {
            Cipher cipher = getCipherInstance();
            byte[] byteText = pureText.getBytes();
            IvParameterSpec iv;

            iv = buildIV();
            cipher.init(Cipher.ENCRYPT_MODE, getKey(), iv);

            byte[] byteCipherText = cipher.doFinal(byteText);
            return addIVInMessage(iv, byteCipherText);

        } catch (Exception e) {
            throw new Exception("Unexpected error on encrypt message.", e);
        }
    }*/
}