import java.sql.ResultSet;
import java.sql.SQLException;

import com.generation.util.Config;
import com.generation.util.Date;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String date = "2021-02-01";
	

//		String s = "SELECT * FROM POST WHERE TAGS LIKE'%food%'";
//		System.out.println(Config.getInstance().conn.createStatement()
//				.executeQuery(s));
//
//		
//		Date d = new Date(1,2,2000);
//		test(12);
	}

	public static void test(Object x) {
		if(x instanceof String)
			System.out.println("una stringa");
		else
			try {
				new Integer((int) x);
				System.out.println("numero");
			}catch(Exception e) {
				System.out.println("altro");
			}
	}
	
}