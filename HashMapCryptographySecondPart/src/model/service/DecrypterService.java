package model.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class DecrypterService {
	
    private final PrivateKey privateKey;
    
    public DecrypterService(String privateKeyPath) throws Exception {
        this.privateKey = loadPrivateKey(privateKeyPath);
    }
    
    private PrivateKey loadPrivateKey(String path) throws Exception {
        byte[] base64 = Files.readAllBytes(Paths.get(path));
        byte[] keyBytes = Base64.getDecoder().decode(new String(base64).trim());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(spec);
    }
    
    public String decrypt(File binFile) throws Exception {
        if (!binFile.exists()) {
            throw new FileNotFoundException("File not found: " + binFile.getName());
        }

        byte[] cryptographyData = Files.readAllBytes(binFile.toPath());

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedData = cipher.doFinal(cryptographyData);

        return new String(decryptedData);
    }

	
    
}