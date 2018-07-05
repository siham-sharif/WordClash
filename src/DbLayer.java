import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DbLayer {

    public String url = "jdbc:mysql://localhost:3306/wordclash_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    //public String url = "jdbc:mysql://localhost:3306/wordclash_db";
    public String user = "root";
    public String pass = "therap"; // therap123 in home pc
    public Connection connection;

    public Statement statement;
    public ResultSet resultSet;
    boolean userExists = false;

    //user name same across the game
    public static String currentUserName;

    public String difficulty;

    public String getDifficultyLevel(){
        return this.difficulty;
    }

    public void checkLogin(String inputFromUser){

        currentUserName=inputFromUser;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT user_name FROM user");

            while(resultSet.next()) {
                String userName = (String) resultSet.getString("user_name");
                if (userName.equals(inputFromUser) || (userName.equals(inputFromUser.toLowerCase())))
                {
                    userExists = true;
                    if (userExists) {
                        System.out.println("User exists in Database");
                        break;
                    }
                }
                else
                    userExists = false;
            }

                if(!userExists){

                    System.out.println("No user found in DB\n Creating user");

                    String initialScore = "0";
                    String initialUserInsertQuery = "INSERT INTO user(user_name,score) VALUES ('"+inputFromUser+"', '"+initialScore+"')";

                    statement.executeUpdate(initialUserInsertQuery);
                    statement.close();
                    connection.close();

                    new MenuFrame();

                }
                else{

                    // calling menu
                    new MenuFrame();
                }

        } catch (Exception e){
            e.printStackTrace();

        }

    }

    public ArrayList<Users> checkRankList(){
        Users users;
        ArrayList<Users> usersArrayList = new ArrayList<Users>();

        try{
            // http://1bestcsharp.blogspot.com/2015/05/java-populating-jtable-mysql-database-arraylist.html

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user ORDER BY score DESC");

            while (resultSet.next()){
                users = new Users(
                        resultSet.getString("user_name"),
                        resultSet.getString("score")
                );

                usersArrayList.add(users);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return usersArrayList;
    }

    public ArrayList<String> wordFetcher(String difficulty, int limit){

        this.difficulty = difficulty;
        int wordLength=0;
        String sign= "=" , dbName="word_easy";

        switch (difficulty) {
            case "easy.one": dbName="word_easy"; wordLength = 3; sign = "<=";
                break;
            case "easy.two": dbName="word_easy"; wordLength = 3; sign = "=";
                break;
            case "easy.three": dbName="word_easy"; wordLength = 4; sign = ">=";
                break;
            case "medium.one": dbName="word_medium"; wordLength = 4; sign = "=";
                break;
            case "medium.two": dbName="word_medium"; wordLength = 6; sign = "<=";
                break;
            case "medium.three": dbName="word_medium"; wordLength = 5; sign = ">=";
                break;
            case "hard.one": dbName="word_hard"; wordLength = 4; sign = "=";
                break;
            case "hard.two": dbName="word_hard"; wordLength = 6; sign = "<=";
                break;
            case "hard.three": dbName="word_hard"; wordLength = 6; sign = ">";
                break;
            default:
                System.out.printf("DB layer : difficulty level %s", difficulty);
                break;
        }

        ArrayList<String> wordArrayList = new ArrayList<String>();
        try{
            // http://1bestcsharp.blogspot.com/2015/05/java-populating-jtable-mysql-database-arraylist.html

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.createStatement();
            //resultSet = statement.executeQuery("SELECT word FROM word_easy ORDER BY RAND() LIMIT 5");
            resultSet = statement.executeQuery("SELECT word FROM "+ dbName +
                                                    " WHERE LENGTH( word ) "+ sign + " " + wordLength +
                                                    " ORDER BY RAND( ) LIMIT " + limit);

            while(resultSet.next()){
                wordArrayList.add(resultSet.getString("word"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return wordArrayList;
    }

    public boolean wordExist(String inputWord){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM word_tb");

            //using LIKE in java code : https://stackoverflow.com/questions/6599950/how-to-use-mysql-like-operator-in-jdbc

            //inputWord has default prefix --> word:
            //so we had to split it and use the latter part to compare in DB
            String origWord[] = inputWord.split(" ");

            while(resultSet.next()){
                String dbWord = (String) resultSet.getString("word");

                if(dbWord.equals(origWord[1]))
                {
                    JOptionPane.showMessageDialog(null, "SUCCESS");
                    return true;
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void updateScore(String userScore){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.createStatement();

            //UPDATE `user` SET `user_name`=[value-1],`score`=[value-2] WHERE 1
            statement.executeUpdate("UPDATE user SET score ='" +  userScore+ "' WHERE user_name = '" + currentUserName + "'");

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

}
