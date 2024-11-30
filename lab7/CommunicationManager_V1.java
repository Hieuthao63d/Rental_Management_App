import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Message class with a single print method to avoid duplication
class Message {
    private final String content;
    private final String sender;
    private final String recipient;

    public Message(String content, String sender, String recipient) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }

    // Getters for message properties
    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    private void printMessageDetails(boolean printFullDetails) {
        System.out.println("Content: " + content);
        System.out.println("Sender: " + sender);
        System.out.println("Recipient: " + recipient);
        if (printFullDetails) {
            System.out.println("Content Length: " + content.length());
            System.out.println("Sender Uppercase: " + sender.toUpperCase());
            System.out.println("Recipient Lowercase: " + recipient.toLowerCase());
        }
    }

    // Summary method
    public void printSummary() {
        printMessageDetails(false);
    }

    // Detailed method
    public void printDetails() {
        printMessageDetails(true);
    }
}

// MessagingService class responsible only for message management
class MessagingService {
    private final Map<String, List<Message>> inbox;

    public MessagingService() {
        this.inbox = new HashMap<>();
    }

    public void sendMessage(String content, String sender, String recipient) {
        Message message = new Message(content, sender, recipient);
        inbox.computeIfAbsent(message.getRecipient(), k -> new ArrayList<>()).add(message);
    }

    // Return Optional to indicate absence of messages clearly
    public Optional<List<Message>> getMessagesForRecipient(String recipient) {
        return Optional.ofNullable(inbox.get(recipient));
    }

    // Separate responsibility: Use MessagePrinter for printing
    public void printAllMessages() {
        MessagePrinter printer = new MessagePrinter();
        for (List<Message> messages : inbox.values()) {
            messages.forEach(printer::printMessage);
        }
    }
}

// New class to handle printing responsibilities
class MessagePrinter {

    // Print summary of a message
    public void printMessage(Message message) {
        System.out.println("Recipient: " + message.getRecipient());
        System.out.println("Sender: " + message.getSender());
        System.out.println("Content: " + message.getContent());
    }
}

public class Main {
    public static void main(String[] args) {
        MessagingService messagingService = new MessagingService();

        // sending messages
        messagingService.sendMessage("Hello, tenant!", "Property Manager", "Tenant A");
        messagingService.sendMessage("Important notice: Rent due next week.", "Property Owner", "Tenant A");
        messagingService.sendMessage("Maintenance request received.", "Tenant A", "Property Manager");

        // retrieving messages for a recipient
        Optional<List<Message>> tenantAMessages = messagingService.getMessagesForRecipient("Tenant A");
        tenantAMessages.ifPresent(messages -> 
            messages.forEach(message -> 
                System.out.println("From: " + message.getSender() + ", Content: " + message.getContent())
            )
        );

        // Calling the new method
        Message exampleMessage = new Message("Test", "Sender", "Recipient");
        exampleMessage.printDetails();

        // Printing all messages
        messagingService.printAllMessages();
    }
}
