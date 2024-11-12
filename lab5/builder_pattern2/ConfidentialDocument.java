
package lab5.builder_pattern2;


import java.io.FileOutputStream;
import java.security.SecureRandom;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// import com.mycompany.cse483_lab5.builder_pattern2.Document;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
/**
 *
 * @author Phan Thao
 */
public class ConfidentialDocument implements Document{
    private String fileName;
    private String content;
    private static final String AES = "AES";

    public ConfidentialDocument(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public void save() {
        try {
            // Generate AES key
            SecretKey secretKey = generateAESKey();
            
            // Encrypt the content
            byte[] encryptedContent = encryptContent(content, secretKey);

            // Save encrypted content as .zip file
            try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(fileName))) {
                ZipEntry zipEntry = new ZipEntry("encryptedContent");
                zipOut.putNextEntry(zipEntry);
                zipOut.write(encryptedContent);
                zipOut.closeEntry();
            }

            System.out.println("Saved as .zip file with AES encryption: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(AES);
        keyGen.init(128, new SecureRandom());
        return keyGen.generateKey();
    }

    // Encrypt Content
    private byte[] encryptContent(String content, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(content.getBytes());
    }
}
