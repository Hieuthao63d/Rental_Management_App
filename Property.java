public class Property {
    private String propertyId;
    private String description;
    private String propertyOwnerId;

    // Constructor
    public Property(String propertyId, String description, String propertyOwnerId) {
        this.propertyId = propertyId;
        this.description = description;
        this.propertyOwnerId = propertyOwnerId;
    }

    // Getter và Setter
    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyOwnerId() {
        return propertyOwnerId;
    }

    public void setPropertyOwnerId(String propertyOwnerId) {
        this.propertyOwnerId = propertyOwnerId;
    }

    // Method thêm property
    public void addProperty() {
        System.out.println("Property added with ID: " + propertyId);
    }

    // Method xóa property
    public void removeProperty() {
        System.out.println("Property with ID: " + propertyId + " has been removed.");
    }

    // Hiển thị thông tin property
    public void displayPropertyInfo() {
        System.out.println("Property ID: " + propertyId);
        System.out.println("Description: " + description);
        System.out.println("Owner ID: " + propertyOwnerId);
    }
}