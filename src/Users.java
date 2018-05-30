public class Users {

    private String userName;
    private String userScore;

    public Users (String userName, String userScore) {
        this.userName = userName;
        this.userScore = userScore;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getUserScore(){
        return this.userScore;
    }
}