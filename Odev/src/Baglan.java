								// VERİ TABANI BAĞLANTISI VE TABLO GÖRÜNTÜLEME; KULLANICI EKLEME,SİLME,GÜNCELLEME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;					

public class Baglan implements Gonder{
private String kullanici_adi = "root";
	
	private String parola  ="";

	private String db_ismi = "bilgiler";
	
	private String host = "localhost";
	
	private int port = 3306;
	
	private Connection con = null;		
	private Statement statement = null;	
	


public void calisanlariGetir(String bilgi) {			// Veri tabanında seçilen tabloya erişilip yazdırılıyor...
	String sorgu = "SELECT * FROM "+bilgi;
	
	try {
		statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sorgu);
		while(rs.next()) {
			int id = rs.getInt("id");
			String ad = rs.getString("Ad");
			String soyad = rs.getString("Soyad");
			String email = rs.getString("email");
			String satisSayisi = rs.getString("Satis_Sayisi");
			
			System.out.println("id : "+id+"| Ad : "+ ad+"| Soyad : "+soyad+"| email : "+email+ "| Satis_Sayisi : "+satisSayisi);
			
		}
		
	}
	catch(SQLException ex) {
		Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE,null,ex);	
	}
}


public void kullaniciEkle(String isim,String soyisim,String email1,String satisSayisi1,String bilgi) {	// Veri tabanında seçilen tabloya yeni kişi oluşturuluyor...
	
	try {
		statement = con.createStatement();
		String ad = isim;
		String soyad = soyisim;
		String email = email1;
		String satisSayisi = satisSayisi1;
	String sorgu = "Insert Into "+bilgi+" (Ad,Soyad,email,Satis_Sayisi) VALUES("+"'"+ad+"',"+"'"+soyad+"',"+"'"+email+"',"+"'"+satisSayisi+"')";
	statement.executeUpdate(sorgu);
	
	}
	
	catch(SQLException ex) {
			Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE,null, ex);
	}
}

public void calisanGuncelle(int id,String ad,String soyad,String email,String satisSayisi,String bilgi) {	// Veri tabanında, seçilen calisana erişilip güncelleniyor...
	

	
	try {
		statement = con.createStatement();
	String sorgu = "Update "+bilgi+" Set Ad ='"+ad+"',Soyad ='"+soyad+"',email ='"+email+"',Satis_Sayisi ="+satisSayisi+" where id ='"+id+"'";
	statement.executeUpdate(sorgu);
	}
	catch(SQLException ex){
	Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE,null, ex);
	
	}
}
public void calisanSil(String bilgi,int id) {					// Veri tabanında, seçilen calisana erişilip siliniyor...
	
	try {
		
		statement = con.createStatement();
		String sorgu = "Delete from "+bilgi+" where id = "+id;
		statement.executeUpdate(sorgu);
		

	}
	catch(SQLException ex){
		Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE,null, ex);
		
		}
}


	public Baglan() {
		// jdbc:mysql://localhost:3306/bilgiler
		String url = "jdbc:mysql://" + host + ":" + port +"/" + db_ismi;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Driver Bulunamadi...");
		}
		
		try {
			con = DriverManager.getConnection(url,kullanici_adi,parola);
			System.out.println("Baglanti Basarili!");
		
		}
		catch (SQLException ex) {
			System.out.println("Baglanti basarisiz...");
			
		}
	
	
}


	@Override
	public void kullaniciEkle() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void calisanlariGetir() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void calisanGuncelle() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void calisanSil() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
