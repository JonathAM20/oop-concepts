package main.java.model;

public abstract class AbstractionLogin {

    private String username;
    private String password;
    private String picture;

    public AbstractionLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void login() {
        if (usernameAndPassordValidation()) {
            if (facialRecognitionValidation()) {
                showWelcomeMessage();
            }
        }
    }

    private boolean usernameAndPassordValidation() {
        if (username.equals("admin") && password.equals("admin")) {
            this.picture = "PROFILE_PRICTURE";
            return true;
        }
        return false;
    };

    private boolean facialRecognitionValidation() {
        String deviceCameraPicture = "PROFILE_PRICTURE";
        if (this.picture.equals(deviceCameraPicture)) {
            return true;
        }
        return false;
    };

    private void showWelcomeMessage() {
        System.out.println("Welcome Administrator!");
    };
}