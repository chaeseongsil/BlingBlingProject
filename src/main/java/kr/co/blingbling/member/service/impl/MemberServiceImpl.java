package kr.co.blingbling.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blingbling.member.domain.Member;
import kr.co.blingbling.member.service.MemberService;
import kr.co.blingbling.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertMember(Member member) {
		int result = mStore.insertMember(sqlSession, member);
		return result;
	}

	@Override
	public int updateMember(Member member) {
		int result = mStore.updateMember(sqlSession, member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		int result = mStore.deleteMember(sqlSession, memberId);
		return result;
	}

	@Override
	public Member selectCheckLogin(Member member) {
		Member mOne = mStore.selectCheckLogin(sqlSession, member);
		return mOne;
	}

	@Override
	public Member selectOneById(String memberId) {
		Member member = mStore.selectOneById(sqlSession, memberId);
		return member;
	}

	@Override
	public Member selectOneFindId(Member mOne) {
		Member member = mStore.selectOneFindId(sqlSession, mOne);
		return member;
	}

	@Override
	public Member selectOneFindPw(Member member) {
		Member mOne = mStore.selectOneFindPw(sqlSession, member);
		return mOne;
	}

	@Override
	public int selectIdCheck(String memberId) {
		int result = mStore.selectIdCheck(sqlSession, memberId);
		return result;
	}

}
