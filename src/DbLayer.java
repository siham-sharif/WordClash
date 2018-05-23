import javax.xml.transform.Result;
import java.sql.*;

public class DbLayer {

    public String url = "jdbc:mysql://127.0.0.1:3306/wordclash_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    public String user = "root";
    public String pass = "therap";
    public Connection connection;

    public Statement statement;
    public ResultSet resultSet;
    boolean userExists = false;

    public void checkLogin(String inputFromUser){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user");

            while(resultSet.next()){
                String userName = (String) resultSet.getString("user_name");
                if(userName.equals(inputFromUser) || (userName.equals(inputFromUser.toLowerCase())));
                {
                    userExists = true;
                    if(userExists){
                        System.out.println("User exists in Database");
                    }
                }

                if(!userExists){

                    System.out.println("No user found in DB\n Creating user");

                    String intialScore = "0";
                    String initialUserInsertQuery = "INSERT INTO user(user_name,score) VALUES ('"+inputFromUser+"', '"+intialScore+"')";

                    statement.executeQuery(initialUserInsertQuery);
                    statement.close();
                    connection.close();

                    new MenuFrame();

                }
                else{

                    // calling menu
                    new MenuFrame();
                }
            }



        } catch (Exception e){
            e.printStackTrace();

        }

    }


}
