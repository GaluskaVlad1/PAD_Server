package pad.server.pad;

public class Answer {
    private boolean loginSuccess;
    private boolean isAdmin;

    public Answer(boolean loginSuccess, boolean isAdmin){
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
