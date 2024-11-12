/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.util.Scanner;

import lab5.builder_pattern2.ConfidentialDocumentBuilder;
import lab5.builder_pattern2.Document;
import lab5.builder_pattern2.DocumentBuilder;
import lab5.builder_pattern2.NormalDocumentBuilder;

public class Client {
    public static void requestCreateRentalContract() {
        Scanner scanner = new Scanner(System.in);

        // Collect contract information
        System.out.print("Enter Contract ID: ");
        String contractID = scanner.nextLine();

        System.out.print("Enter Property ID: ");
        String propertyID = scanner.nextLine();

        System.out.print("Enter Tenant ID: ");
        String tenantID = scanner.nextLine();

        System.out.print("Enter Rent Amount: ");
        double rentAmount = scanner.nextDouble();

        // Select contract type
        System.out.println("Select Contract Type: ");
        System.out.println("1. Permanent Contract");
        System.out.println("2. Long-Term Contract");
        System.out.println("3. Short-Term Contract");
        int choice = scanner.nextInt();

        Contract contract;
        switch (choice) {
            case 1:
                contract = new PermanentContract();
                break;
            case 2:
                contract = new LongTermContract();
                break;
            case 3:
                contract = new ShortTermContract();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Short-Term Contract.");
                contract = new ShortTermContract();
        }

        // Build and sign the contract
        Contract signedContract = new ContractBuilder(contract)
                .buildContractID(contractID)
                .buildPropertyID(propertyID)
                .buildTenantID(tenantID)
                .buildRentAmount(rentAmount)
                .signContract();

        // Display contract details
        System.out.println("Contract details:");
        System.out.println(signedContract);

        // Prompt for document saving preference
        System.out.println("Choose document saving format:");
        System.out.println("1. Normal (.txt file)");
        System.out.println("2. Encrypted (.zip file with AES encryption)");
        int saveChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter file name to save the contract: ");
        String fileName = scanner.nextLine();
        String content = signedContract.toString(); // Convert contract details to a string for saving

        Document document;
        if (saveChoice == 1) {
            // Save as a normal document
            DocumentBuilder documentBuilder = new NormalDocumentBuilder();
            document = documentBuilder.setFileName(fileName).setContent(content).build();
        } else if (saveChoice == 2) {
            // Save as an encrypted document
            DocumentBuilder documentBuilder = new ConfidentialDocumentBuilder();
            document = documentBuilder.setFileName(fileName).setContent(content).build();
        } else {
            System.out.println("Invalid choice. Saving as normal document by default.");
            DocumentBuilder documentBuilder = new NormalDocumentBuilder();
            document = documentBuilder.setFileName(fileName).setContent(content).build();
        }

        // Save the document
        document.save();
        System.out.println("Contract saved successfully!");

        scanner.close();
    }
}
