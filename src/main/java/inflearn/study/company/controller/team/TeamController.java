package inflearn.study.company.controller.team;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inflearn.study.company.dto.response.team.TeamReadResponse;
import inflearn.study.company.dto.request.team.TeamCreateRequest;
import inflearn.study.company.service.team.TeamService;

@RestController
public class TeamController {

	private final TeamService teamService;

	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	/**
	 * 팀 등록
	 * @param request
	 */
	@PostMapping("/team")
	public void createTeam(@RequestBody TeamCreateRequest request) {
		teamService.createTeam(request);
	}

	/**
	 * 팀 조회 기능
	 * @return
	 */
	@GetMapping("/team")
	public List<TeamReadResponse> getAllTeams() {
		return teamService.getAllTeams();
	}
}
