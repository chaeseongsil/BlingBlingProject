package kr.co.blingbling.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.blingbling.member.domain.Member;
import kr.co.blingbling.member.service.MemberService;

@Controller
@SessionAttributes("memberId")
public class MemberController {
	
	@Autowired
	private MemberService service;

	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String showloginForm() {
		return "member/login";
	}

	@RequestMapping(value="/member/login.do", produces="text/html;charset=UTF-8;", method=RequestMethod.POST)
	public @ResponseBody String memberLogin(
			@RequestParam("userId") String memberId
			, @RequestParam("userPw") String memberPw
			, Model model
			) {
		Member member = new Member(memberId, memberPw);
		Member mOne = service.selectCheckLogin(member);
		if(mOne != null) {
			model.addAttribute("memberId", memberId);
			return "<script>alert('"+memberId+"님 환영합니다.'); location.href='/index.jsp';</script>";
		}else {
			return "<script>alert('회원 정보가 존재하지 않습니다.'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String memberLogout(
			SessionStatus session
			) {
		if(session != null) {
			session.setComplete();
		}
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="/member/register.do", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "member/register";
	}
	
	@RequestMapping(value="/member/register.do", produces="text/html;charset=UTF-8;",  method=RequestMethod.POST)
	public @ResponseBody String registerMember(
			@RequestParam("userId") String memberId
			, @RequestParam("userPw") String memberPw
			, @RequestParam("userName") String memberName
			, @RequestParam("userPost") String memberPostCode
			, @RequestParam("userPostAddr1") String memberAddr1
			, @RequestParam("userPostAddr2") String memberAddr2
			, @RequestParam("tel1") String memberPhone1
			, @RequestParam("tel2") String memberPhone2
			, @RequestParam("userEmail") String memberEmail
			, Model model
			) {
		String memberPhone = memberPhone1 + memberPhone2;
		Member member = new Member(memberId, memberPw, memberName, memberPostCode, memberAddr1, memberAddr2, memberPhone, memberEmail);
		int result = service.insertMember(member);
		if(result > 0) {
			return "<script>alert('가입이 완료되었습니다. 로그인해주세요.'); location.href='/member/login.do'</script>";
		}else {
			return "<script>alert('회원가입 실패'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/member/myInfo.do", method=RequestMethod.GET)
	public String showMyInfo(
			@RequestParam("member-id") String memberId
			, Model model
			) {
		Member member = service.selectOneById(memberId);
		model.addAttribute("member", member);
		return "member/modifyInfo";
	}
	
	@RequestMapping(value="/member/update.do", produces="text/html;charset=UTF-8;", method=RequestMethod.POST)
	public @ResponseBody String modifyMyInfo(
			@RequestParam("userId") String memberId
			, @RequestParam("userPw") String memberPw
			, @RequestParam("userName") String memberName
			, @RequestParam("userPost") String memberPostCode
			, @RequestParam("userPostAddr1") String memberAddr1
			, @RequestParam("userPostAddr2") String memberAddr2
			, @RequestParam("tel1") String memberPhone1
			, @RequestParam("tel2") String memberPhone2
			, @RequestParam("userEmail") String memberEmail
			) {
		String memberPhone = memberPhone1 + memberPhone2;
		Member member = new Member(memberId, memberPw, memberName, memberPostCode, memberAddr1, memberAddr2, memberPhone, memberEmail);
		int result = service.updateMember(member);
		if(result > 0) {
			return "<script>alert('정보가 수정되었습니다.'); location.href='/index.jsp';</script>";
		}else {
			return "<script>alert('회원정보를 수정할 수 없습니다.'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/member/delete.do", produces="text/html;charset=UTF-8;", method=RequestMethod.GET)
	public @ResponseBody String removeMember(
			@RequestParam("memberId") String memberId
			) {
		int result = service.deleteMember(memberId);
		if(result > 0) {
			return "<script>alert('정상적으로 탈퇴되었습니다. 이용해주셔서 감사합니다.'); location.href='/index.jsp'</script>";
		}else {
			return "<script>alert('회원탈퇴를 실패하였습니다.'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/member/findId.do", method=RequestMethod.GET)
	public String showFindIdView() {
		return "member/findId";
	}
	
	@RequestMapping(value="/member/findId.do", produces="text/html;charset=UTF-8;", method=RequestMethod.POST)
	public @ResponseBody String findMemberId(
			@RequestParam("userName") String memberName
			, @RequestParam("userEmail") String memberEmail
			) {
		Member member = new Member();
		member.setMemberName(memberName);
		member.setMemberEmail(memberEmail);
		Member mOne = service.selectOneFindId(member);
		if(mOne != null) {
			return "<script>alert('ID는 "+mOne.getMemberId()+"입니다. 로그인 페이지로 이동합니다.'); location.href='/member/login.do';</script>";
		}else {
			return "<script>alert('회원정보가 존재하지 않습니다.'); history.back();</script>";
		}
	}
	
	@RequestMapping(value="/member/findPw.do", method=RequestMethod.GET)
	public String showFindPwView() {
		return "member/findPw";
	}
	
	@RequestMapping(value="/member/findPw.do", produces="text/html;charset=UTF-8;", method=RequestMethod.POST)
	public @ResponseBody String findMemberPw(
			@RequestParam("userId") String memberId
			, @RequestParam("userName") String memberName
			, @RequestParam("userEmail") String memberEmail
			) {
		Member member = new Member(memberId, memberName, memberEmail);
		Member mOne = service.selectOneFindPw(member);
		if(mOne != null) {
			return "<script>alert('비밀번호는 "+mOne.getMemberPw()+"입니다. 로그인 페이지로 이동합니다.'); location.href='/member/login.do';</script>";
		}else {
			return "<script>alert('회원정보가 존재하지 않습니다.'); history.back();</script>";
		}
	}
}
