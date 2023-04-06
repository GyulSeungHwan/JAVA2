package com.yedam.member;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	//impl = service
	//로그인.. 메뉴를 이동할때마다 그 로그인 정보가 남아있어야한다.
	//정적 멤버(static)
	//1. login
	//login 성공
	//login -> id/pw -> 정보 조회 성공 -> 로그인
	//로그인 -> 정적 필드에게 로그인한 정보를 입력
	//login 실패
	//정보 조회 실패 -> 정적 필드에 데이터 안 넣어 준다.
	public static Member memberInfo = null;
	//공용   공유    객체타입    객체    객체 안에 내용 x
	//login X -> 데이터 X
	//DB에서 조회된 데이터가 memberInfo(객체)에 들어간다
	Scanner sc = new Scanner(System.in);
	public void login() {
		//id 입력
		System.out.println("ID>");
		String id = sc.nextLine();
		
		System.out.println("PW>");
		String pw = sc.nextLine();
		
		//1. member == null (id가 없다)
		//2. member != null (회원 정보가 있다)
		Member member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getPw().equals(pw)) {
				System.out.println("정상 로그인 되었습니다.");
				System.out.println(member.getName() + "님 환영합니다.");
				memberInfo = member;
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}
	
	public void logout() {
		memberInfo = null;
		System.out.println("로그아웃 성공");
	}
	
	//전체 조회
	public void getMemberList() {
		List<Member> list = MemberDAO.getInstance().getMemberList();
		
		for(Member member : list) {
			System.out.println("ID : " + member.getId());
			System.out.println("PW : " + member.getPw());
			System.out.println("NM : " + member.getName());
		}
	}
	
	//회원 등록
	public void memberAdd() {
		
		String id = "";
		while(true) {
			System.out.println("ID>");
			id = sc.nextLine();
			//=if(MemberDAO.getInstance().login(id) == null){
			Member member = MemberDAO.getInstance().login(id);
			if(member == null) {
				System.out.println("회원 가입 가능");
				break;
			}else {
				System.out.println("ID 중복, 재입력");
			}
		}
		
		
		System.out.println("PW>");
		String pw = sc.nextLine();
		System.out.println("이름>");
		String name = sc.nextLine();
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		
		int result = MemberDAO.getInstance().memberAdd(member);
		
		if(result == 1) {
			System.out.println("회원 등록 성공");
		}else {
			System.out.println("회원 등록 실패");
		}
	}
	
	//회원 수정
	//login 되어 있는 정보를 수정하는지 -> 실시간으로 로그인 된 정보도 바꿔줘야한다
	//login 안되어 있는 정보를 수정하는지
	public void memberUpdate() {
		
		System.out.println("ID>");
		String id = sc.nextLine();
		System.out.println("PW>");
		String pw = sc.nextLine();
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		int result = MemberDAO.getInstance().memberUpdate(member);
		//DB의 결과가 바뀌고 나서 업데이트를 해야한다
		//DB의 결과가 바뀌겠지? 라고 생각하면서 코딩을 하면 안된다
		
		if(result > 0) {
			//실시간으로 로그인 된 정보도 바꿔줘야한다.
			if(id.equals(memberInfo.getId())){
				memberInfo = MemberDAO.getInstance().login(id);
				//수정된 내용이 id + DB 정보 조회 한것을
				//memberInfo(접속한유저)에게 새롭게 갱신해야한다
			}
		}else {
			System.out.println("PW 변경 실패");
		}
	}
	
	public void memberDelete() {
		System.out.println("삭제 ID>");
		String id = sc.nextLine();
		
		int result = MemberDAO.getInstance().memberDelete(id);
		
		if(result > 0) {
			if(id.equals(memberInfo.getId())) {
				memberInfo = null;
			}
		}else {			
			System.out.println("삭제 완료");
		}
	}
	
	
}
