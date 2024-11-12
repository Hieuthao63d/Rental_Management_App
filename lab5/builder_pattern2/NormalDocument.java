/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5.builder_pattern2;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Phan Thao
 */
public class NormalDocument implements Document{
    private String fileName;
    private String content;

    public NormalDocument(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public void save() {
        try (OutputStream out = new FileOutputStream(fileName)) {
            out.write(content.getBytes());
            System.out.println("Saved as .txt file: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
