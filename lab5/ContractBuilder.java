/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.util.Scanner;

import lab5.builder_pattern2.ConfidentialDocumentBuilder;
import lab5.builder_pattern2.Document;
import lab5.builder_pattern2.NormalDocumentBuilder;

/**
 *
 * @author Phan Thao
 */
public class ContractBuilder {
    private Contract contract;

    public ContractBuilder(Contract contract) {
        this.contract = contract;
    }

    public ContractBuilder buildContractID(String contractID) {
        contract.buildContractID(contractID);
        return this;
    }

    public ContractBuilder buildPropertyID(String propertyID) {
        contract.buildPropertyID(propertyID);
        return this;
    }

    public ContractBuilder buildTenantID(String tenantID) {
        contract.buildTenantID(tenantID);
        return this;
    }

    public ContractBuilder buildRentAmount(double rentAmount) {
        contract.buildRentAmount(rentAmount);
        return this;
    }

    public Contract signContract() {
        return contract.signContract();
    }
    public void exportContract(String fileName, String content) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Save contract as (1) Normal (.txt) or (2) Encrypted (.zip)? ");
        int choice = scanner.nextInt();
        Document document;

        if (choice == 1) {
            document = new NormalDocumentBuilder()
                .setFileName(fileName)
                .setContent(content)
                .build();
        } else if (choice == 2) {
            document = new ConfidentialDocumentBuilder()
                .setFileName(fileName)
                .setContent(content)
                .build();
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        document.save();
        System.out.println("Contract saved successfully!");
        scanner.close();
    }
}
