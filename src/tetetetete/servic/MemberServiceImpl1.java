package tetetetete.servic;

import java.util.Scanner;

import tetetetete.DAO.MemberDAO1;
import tetetetete.DTO.MemberDTO1;

public class MemberServiceImpl1 implements MemberService1 {
	
	Scanner input = new Scanner(System.in);
	private MemberDAO1 dao;
	public MemberServiceImpl1() {
		dao = new MemberDAO1();
		
	}
	public void display() {
		while(true) {
		System.out.println("1.로그인");
		System.out.println("2.회원가입");
		System.out.println("3.과리자로그인");
		System.out.println("4.종료");
		System.out.println(">>>>> :");
		int select = input.nextInt();
		if(select ==4) break;
			if(select ==1) {
				System.out.println("로그인 화면");
				Login();
			}
			else if(select == 2) {
				System.out.println("회원가입 화면");
				join();
			}
			else if(select == 3) {
				System.out.println("관리자로그인 화면");
				root();
			}
	    }
	}
	public void Login() {
		System.out.println("아이디를 입력해주세요 :");
		String id = input.next();
		System.out.println("패스워드를 입력해주세요 :");
		String pwd = input.next();
		
		MemberDTO1 LDTO=dao.memberLogin(id,pwd);
		
		if(LDTO.getUser_id() != null) {
			System.out.println(LDTO.getUser_id());
			System.out.println(LDTO.getUser_pwd());
			System.out.println(LDTO.getUser_tel());
		}
		//int result =dao.memberLogin(id, pwd);
		//if(result ==1) {
		//	System.out.println(id+"님이 로그인 성공");
		//}else {
		//	System.out.println("로그인 실패");
		//}
		/*
		System.out.println(LDTO.getUser_id());
		System.out.println(LDTO.getUser_pwd());
		System.out.println(LDTO.getUser_tel());
		System.out.println(LDTO.getUser_addr());
	*/
	}
	
	public void join() {
		System.out.println("아이디 :");
		String id =input.next();
		System.out.println("패스워드 :");
		String pwd = input.next();
		System.out.println("전화번호 :");
		String tel = input.next();
		System.out.println("주소 :");
		input.nextLine();
		String addr = input.nextLine();
		dao.join(id,pwd,tel,addr);
		
	}
	public void root() {
		
	}
}
