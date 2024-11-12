/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5.builder_pattern2;

/**
 *
 * @author Phan Thao
 */
public class NormalDocumentBuilder implements DocumentBuilder{
    private String fileName;
    private String content;

    @Override
    public DocumentBuilder setFileName(String fileName) {
        this.fileName = fileName + ".txt";
        return this;
    }

    @Override
    public DocumentBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public Document build() {
        return new NormalDocument(fileName, content);
    }
}
