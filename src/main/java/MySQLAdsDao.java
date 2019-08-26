import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection() throws SQLException {
        Config config = new Config();
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
        return connection;
    }
    public List<Ad> all() {
        try {
            Statement statement = connection().createStatement();
            String query ="SELECT * FROM users";
            ResultSet result =  statement.executeQuery(query);
            if (result != null) {
                System.out.println("found it!");
                while(result.next()){
                    System.out.println(result.getInt("id")+": "+
                            result.getString("username") +" "+
                            result.getString("password") + " "+
                            result.getString("email")+".");
                    System.out.println("no more");
                }
            }else{
                System.out.println("nothing found");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Long insert(Ad ad) {
        long count = 0;
        try{
            Statement statement = connection().createStatement();
            String query ="INSERT INTO ads(user_id, title, description)"+
                    "VALUES(1,"+ad.getTitle()+","+ad.getDescription()+")";
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet result =  statement.getGeneratedKeys();
            while(result.next()){
                System.out.println("added the ad with id of "+result.getLong(1));
                count++;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return count;
    }
}
