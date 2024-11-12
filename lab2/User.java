package lab2;
public class User {
    private String userId;
    private String password;
    private String email;
    private String userType;

    // Constructor
    public User(String userId, String password, String email, String userType) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    // Getter và Setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    // Method tạo người dùng
    public void createUser() {
        System.out.println("User created with ID: " + userId);
    }

    // Method reset mật khẩu
    public void resetPassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password has been reset.");
    }

    // Hiển thị thông tin người dùng
    public void displayUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Email: " + email);
        System.out.println("User Type: " + userType);
    }
}