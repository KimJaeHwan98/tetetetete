package tetetetete.servic;

import java.util.ArrayList;

import tetetetete.DAO.MemberDAO;
import tetetetete.DTO.MemberDTO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao;
	public MemberServiceImpl() {
		dao = new MemberDAO();
	}
	public void memberView() {
		System.out.println("회원 보기 기능");
		ArrayList<MemberDTO> members = dao.getMembers();
		if(members.size()==0) {
			System.out.println("등록된 정보가 없습니다!");
		}else {
			for(int i = 0; i<members.size();i++) {
				MemberDTO m = members.get(i);
				System.out.println("id :"+m.getId());
				System.out.println("pwd :" + m.getPwd());
				System.out.println("name :" + m.getName());
				System.out.println("age  :"+m.getAge());
				System.out.println("====================");
			}
		}
		
	}
	@Override
	public void modify() {
		// TODO Auto-generated method stub
		
	}
}
