package pad.server.pad;

public class LoginAnswer {
    private boolean loginSuccess;
    private boolean isAdmin;

    public LoginAnswer(boolean loginSuccess, boolean isAdmin){
        this.loginSuccess = loginSuccess;
        this.isAdmin = isAdmin;
    }

    public boolean getLoginSuccess(){
        return loginSuccess;
    }

    public boolean getAdmin(){
        return isAdmin;
    }
}
