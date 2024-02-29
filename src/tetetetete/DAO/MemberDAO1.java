package tetetetete.DAO;

import java.security.AlgorithmParametersSpi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tetetetete.DTO.MemberDTO1;

public class MemberDAO1 {
 private Connection con;
 private PreparedStatement ps;
 private ResultSet rs;
 public MemberDAO1() {
	 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		 String id = "java";
		 String pwd = "1234";
		 con = DriverManager.getConnection(url,id,pwd);
		 System.out.println("db연결완료");
		 
		 
	 }catch (Exception e) {
		 e.printStackTrace();
	}
 }
 public MemberDTO1 memberLogin(String id, String pwd) {
	 String sql = "select * from user_im where user_id=?and user_pwd=?"; 
	 //and user_pwd=?
	 MemberDTO1 dto = null;
	 try {
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pwd);
		rs = ps.executeQuery();
		
		
		dto = new MemberDTO1();
		if(rs.next()) {
		dto.setUser_id(rs.getString("user_id"));
		dto.setUser_pwd(rs.getString("user_pwd"));
		dto.setUser_tel(rs.getString("user_tel"));
		dto.setUser_addr(rs.getString("user_addr"));
		}else {
			System.out.println("로그인에 실패하였습니다.");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return dto;
 }
 public void join(String id, String pwd,String tel, String addr) {
	 String sql = "insert into user_im values(user_im_SEQ.nextval,?,?,?,?,sysdate)";
	 try {
		 ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ps.setString(3, tel);
		ps.setString(4, addr);
		int result = ps.executeUpdate();
		if(result == 1) {
			System.out.println("회원가입이 완료되었습니다.");
		}else {
			System.out.println("회원가입에 실패하였습니다.");
		}
		
	 } catch (java.sql.SQLIntegrityConstraintViolationException e) {
	
		System.out.println("아이디가 중복됩니다.");
	 
	 }catch (Exception e) {
		e.printStackTrace();
	}
 }
}
