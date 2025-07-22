package model.service;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class Encrypter {
	
	private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public Encrypter() throws Exception {
        KeyPair keyPair = generateKeys();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    private KeyPair generateKeys() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    public String getPrivateKeyBase64() {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public String getPublicKeyBase64() {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    
    public File EncrypterAndWrite(String vowsList) throws Exception {
    	
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypterData = cipher.doFinal(vowsList.getBytes());

        
        String fileName = getPublicKeyBase64() + ".bin";
        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(encrypterData);
        }

        return file;
    }
}