import java.util.List;

class Address {
    private String location;
    private String city;

    public Address(String location, String city) {
        this.location = location;
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }
}

class Property {
    private String name;
    private double rentAmount;
    private String ownerName;
    private Address address;  // Sử dụng Address để chứa thông tin về vị trí

    public Property(String name, double rentAmount, String ownerName, Address address) {
        this.name = name;
        this.rentAmount = rentAmount;
        this.ownerName = ownerName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Address getAddress() {
        return address;
    }
}

class PropertyPrinter {
    public static void printPropertyDetails(Property property) {
        System.out.println("Property: " + property.getName());
        System.out.println("Rent Amount: $" + property.getRentAmount());
        System.out.println("Owner: " + property.getOwnerName());
        System.out.println("Location: " + property.getAddress().getLocation() + ", " + property.getAddress().getCity());
    }
}

class FinancialReport {
    private static final double PREMIUM_THRESHOLD = 2000;  // Thay thế magic number
    private String reportTitle;
    private List<Property> properties;
    private double totalRent;

    public FinancialReport(String reportTitle, List<Property> properties) {
        this.reportTitle = reportTitle;
        this.properties = properties;
    }

    private void calculateYearlyRent(Property property) {
        double yearlyRent = property.getRentAmount() * 12;
        System.out.println("Yearly Rent: $" + yearlyRent);
    }

    private void classifyProperty(Property property) {
        if (property.getRentAmount() > PREMIUM_THRESHOLD) {
            System.out.println("This is a premium property.");
        } else {
            System.out.println("This is a standard property.");
        }
    }

    private void printPropertyReport(Property property) {
        PropertyPrinter.printPropertyDetails(property);
        classifyProperty(property);
        calculateYearlyRent(property);
    }

    public void generateReport() {
        totalRent = 0;
        System.out.println("Financial Report: " + reportTitle);
        System.out.println("----------------------------");

        for (Property property : properties) {
            printPropertyReport(property);
            totalRent += property.getRentAmount();
            System.out.println("--------------------");
        }

        System.out.println("Total Rent Amount: $" + totalRent);
    }
}

public class ReportGenerator {
    public static void main(String[] args) {
        Address address1 = new Address("City Center", "New York");
        Address address2 = new Address("Suburb", "Los Angeles");
        Address address3 = new Address("Downtown", "Chicago");

        Property property1 = new Property("Apartment A", 1500.0, "John Doe", address1);
        Property property2 = new Property("House B", 2000.0, "Jane Smith", address2);
        Property property3 = new Property("Condo C", 1800.0, "Bob Johnson", address3);

        FinancialReport financialReport = new FinancialReport("Monthly Rent Summary", List.of(property1, property2, property3));
        financialReport.generateReport();
    }
}
