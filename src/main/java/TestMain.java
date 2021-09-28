<<<<<<< HEAD
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
=======
import java.sql.ResultSet;
import java.sql.SQLException;

import com.generation.util.Config;
import com.generation.util.Date;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String date = "2021-02-01";
		
		
		
		String s = "INSERT INTO POST (title, content, DOP, BLOGGERID, IMGPOST, TAGS, LIKES)"
				+ " VALUES ('azz', 'azz', '2020-10-10','2', 'c','b','a')";
		System.out.println(Config.getInstance().conn.createStatement()
				.executeUpdate(s));

		
		Date d = new Date(1,2,2000);
		test(12);
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
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
