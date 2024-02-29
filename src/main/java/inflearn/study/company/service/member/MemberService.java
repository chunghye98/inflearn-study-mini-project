package inflearn.study.company.service.member;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inflearn.study.company.domain.member.Member;
import inflearn.study.company.domain.member.MemberRepository;
import inflearn.study.company.domain.team.Team;
import inflearn.study.company.domain.team.TeamRepository;
import inflearn.study.company.dto.request.member.MemberCreateRequest;
import inflearn.study.company.dto.response.member.MemberReadResponse;

@Service
public class MemberService {
	private final MemberRepository memberRepository;
	private final TeamRepository teamRepository;

	public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
		this.memberRepository = memberRepository;
		this.teamRepository = teamRepository;
	}

	@Transactional
	public void createMember(MemberCreateRequest request) {
		Team team = teamRepository.findById(request.getTeamId())
			.orElseThrow(IllegalArgumentException::new);

		Member member = new Member(request.getName(), request.getIsManager(), request.getBirthday(),
			request.getWorkStartDate());

		team.addMember(member);

		memberRepository.save(member);
	}

	@Transactional(readOnly = true)
	public List<MemberReadResponse> getAllMembers() {
		List<Member> members = memberRepository.findAll();

		return members.stream()
			.map(member -> {
				String teamName = member.getTeam().getName();

				return new MemberReadResponse(member, teamName);
			}).collect(Collectors.toList());
	}
}
