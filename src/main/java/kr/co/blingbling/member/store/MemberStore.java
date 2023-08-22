package kr.co.blingbling.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.blingbling.member.domain.Member;

public interface MemberStore {
	
	public int insertMember(SqlSession session, Member member);

	public int updateMember(SqlSession session, Member member);
	
	public int deleteMember(SqlSession session, String memberId);
	
	public Member selectCheckLogin(SqlSession session, Member member);
	
	public Member selectOneById(SqlSession session, String memberId);
	
	public Member selectOneFindId(SqlSession session, Member mOne);
	
	public Member selectOneFindPw(SqlSession session, Member member);
	
}
