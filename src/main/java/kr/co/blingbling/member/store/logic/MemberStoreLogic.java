package kr.co.blingbling.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.blingbling.member.domain.Member;
import kr.co.blingbling.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public Member selectCheckLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectCheckLogin", member);
		return mOne;
	}

	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

	@Override
	public Member selectOneFindId(SqlSession session, Member mOne) {
		Member member = session.selectOne("MemberMapper.selectOneFindId", mOne);
		return member;
	}

	@Override
	public Member selectOneFindPw(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectOneFindPw", member);
		return mOne;
	}

}
