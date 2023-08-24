package kr.co.blingbling.member.service;

import kr.co.blingbling.member.domain.Member;

public interface MemberService {
	
	public int insertMember(Member member);

	public int updateMember(Member member);

	public int deleteMember(String memberId);

	public Member selectCheckLogin(Member member);

	public Member selectOneById(String memberId);

	public Member selectOneFindId(Member mOne);

	public Member selectOneFindPw(Member member);

	public int selectIdCheck(String memberId);
}
