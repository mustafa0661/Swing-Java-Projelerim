
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Baglanti {
    
    private String kullanici_adi = "root";
    private String parola = "";
    
    private String db_ismi = "demo";
    
    private String host = "localhost";
    
    private int port = 3306;
    
    private Connection con = null;
    
    
    public Baglanti(){
        
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex){

            System.out.println("Driver bulunamadı");
        }
        
        try {
            con = DriverManager.getConnection(url, kullanici_adi, parola);
            
            System.out.println("Bağlantı başarılı..");
        } catch (SQLException ex) {

            System.out.println("Bağlantı başarısız..");
        }
        
    }
    
    public static void main(String[] args) {
        
        Baglanti baglanti = new Baglanti();
        
    }
    
}
