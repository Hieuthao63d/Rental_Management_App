import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lấy thông tin từ người dùng cho đối tượng User
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter User Type (e.g., Tenant, PropertyOwner): ");
        String userType = scanner.nextLine();

        // Tạo một đối tượng User dựa trên dữ liệu nhập vào
        User user = new User(userId, password, email, userType);
        user.createUser();
        user.displayUserInfo();

        // Reset mật khẩu thông qua người dùng
        System.out.print("Enter new Password to reset: ");
        String newPassword = scanner.nextLine();
        user.resetPassword(newPassword);
        user.displayUserInfo();

        // Lấy thông tin từ người dùng cho đối tượng Property
        System.out.print("Enter Property ID: ");
        String propertyId = scanner.nextLine();

        System.out.print("Enter Property Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Property Owner ID: ");
        String propertyOwnerId = scanner.nextLine();

        // Tạo một đối tượng Property dựa trên dữ liệu nhập vào
        Property property = new Property(propertyId, description, propertyOwnerId);
        property.addProperty();
        property.displayPropertyInfo();

        // Hỏi người dùng có muốn xóa property hay không
        System.out.print("Do you want to remove the property? (yes/no): ");
        String removePropertyAnswer = scanner.nextLine();

        if (removePropertyAnswer.equalsIgnoreCase("yes")) {
            property.removeProperty();
        } else {
            System.out.println("Property has not been removed.");
        }

        // Đóng Scanner sau khi hoàn thành
        scanner.close();
    }
}
