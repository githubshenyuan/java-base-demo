package com.example.controller;


import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;


/**
 * @author sh 2018/12/23 16:23
 * @version ideaIU-2018.2.5.win
 */
public class EncryptController {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        //Check converted string against original String
        createKeys();

    }

    public static void encrypt() throws NoSuchAlgorithmException {


    }

    public static void createKeys() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");


        //初始化KeyPairGenerator对象,密钥长度
        keyPairGenerator.initialize(1024);
        //生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //甲方公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        byte[] a = publicKey.getEncoded();
        System.out.println(new String(a,"ISO-8859-1"));
        //甲方私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        System.out.println(privateKey.getEncoded());
    }
}
