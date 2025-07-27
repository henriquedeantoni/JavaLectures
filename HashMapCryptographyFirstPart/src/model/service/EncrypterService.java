package model.service;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class EncrypterService {
	
	private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public EncrypterService() throws Exception {
    	
    	this.privateKey = loadPrivateKey("/keys/privateKey.key");
        
    	KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
    	
        this.publicKey = generator.generateKeyPair().getPublic();
    }

    private PrivateKey loadPrivateKey(String path) throws Exception {
        byte[] keyBase64 = Files.readAllBytes(Paths.get(path));
        byte[] keyBytes = Base64.getDecoder().decode(new String(keyBase64).trim());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);
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