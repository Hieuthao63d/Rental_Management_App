/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5.builder_pattern2;

// import com.mycompany.cse483_lab5.builder_pattern2.ConfidentialDocument;
// import com.mycompany.cse483_lab5.builder_pattern2.Document;
// import com.mycompany.cse483_lab5.builder_pattern2.DocumentBuilder;

/**
 *
 * @author Phan Thao
 */
public class ConfidentialDocumentBuilder implements DocumentBuilder{
    private String fileName;
    private String content;

    @Override
    public DocumentBuilder setFileName(String fileName) {
        this.fileName = fileName + ".zip";
        return this;
    }

    @Override
    public DocumentBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public Document build() {
        return new ConfidentialDocument(fileName, content);
    }
}
