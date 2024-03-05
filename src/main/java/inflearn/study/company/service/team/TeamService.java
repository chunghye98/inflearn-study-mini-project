package inflearn.study.company.service.team;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inflearn.study.company.domain.member.Member;
import inflearn.study.company.domain.member.Role;
import inflearn.study.company.domain.team.Team;
import inflearn.study.company.domain.team.TeamRepository;
import inflearn.study.company.dto.request.team.TeamCreateRequest;
import inflearn.study.company.dto.response.team.TeamReadResponse;

@Service
public class TeamService {

	private final TeamRepository teamRepository;

	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	@Transactional
	public void createTeam(TeamCreateRequest request) {
		teamRepository.save(new Team(request.getName()));
	}

	@Transactional(readOnly = true)
	public List<TeamReadResponse> getAllTeams() {

		List<Team> teams = teamRepository.findAll();

		return teams.stream().map(team -> {
			String manager = team.getMembers().stream()
				.filter(member -> member.getRole() == Role.MANAGER)
				.findFirst()
				.map(Member::getName)
				.orElse(null); // 관리자가 없는 경우 null을 반환

			int memberCount = team.getMembers().size();

			return new TeamReadResponse(team, manager, memberCount);
		}).collect(Collectors.toList());
	}
}
