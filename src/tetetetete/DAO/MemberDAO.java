package tetetetete.DAO;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tetetetete.DTO.MemberDTO;



public class MemberDAO {
private Connection con;
private PreparedStatement ps;
private ResultSet rs;

public MemberDAO() {
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "java" ,pwd = "1234";
	con = DriverManager.getConnection(url,id,pwd);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public ArrayList<MemberDTO>getMembers() {
	String sql = "select * from member_test";
	ArrayList<MemberDTO> mem = new ArrayList<>();
	try {
		ps=con.prepareStatement(sql);
		rs= ps.executeQuery();
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("pwd"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			
			mem.add(dto);
			
		}
		
	}catch (Exception e) {
	 e.printStackTrace();
	}
	return mem;
}
public MemberDTO memberChk (String id) {
	String sql = "select * from member_test where id=?";
	MemberDTO dto = null;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		if(rs.next()) {
			dto = new MemberDTO();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dto;
}
}

