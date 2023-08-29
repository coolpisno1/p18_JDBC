package pack.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insert {
	
	
	public static void main(String[] args) {
		
		Scanner	scanner	=new Scanner(System.in);
		System.out.print("아이디를 입력하세요: ");
		String	id=scanner.next();
		System.out.print("이름을 입력하세요: ");
		String	name=scanner.next();
		System.out.print("년차를 입력하세요: ");
		int	yearRank=scanner.nextInt();
		System.out.print("직위를 입력하세요: ");
		String	position=scanner.next();
		
		Connection conn;
		PreparedStatement pstmt;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/Company?useSSL=false&";
					url +="useUnicdoe=true&";
					url +="characterEncoding=utf8&";
					url +="serverTimezone=UTC&";
					url +="allowPublicKeyRetrieval=true";
			String uid ="root";
			String upw ="1234";
			conn=DriverManager.getConnection(url, uid, upw);
			
			
			String	sql	=	"insert	into staffList(id, name, yearRank, position)	";
			sql	+=	"values	(?,?,?,?)";
			pstmt	=	conn.prepareStatement(sql);
			pstmt.setString(1,	id);
			pstmt.setString(2,	name);
			pstmt.setInt(3,	yearRank);
			pstmt.setString(4,	position);
			int	rtnVal	=pstmt.executeUpdate();
			if	(rtnVal	==	1)	System.out.println("입력 완료!");	
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("오류발생 : " +e.getMessage());
		}
		
		
		
	}

}
