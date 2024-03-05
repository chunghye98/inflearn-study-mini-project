package inflearn.study.company.dto.response.team;

import inflearn.study.company.domain.team.Team;
import lombok.Getter;

@Getter
public class TeamReadResponse {

	private String name;
	private String manager;
	private long memberCount;

	public TeamReadResponse(Team team, String manager, long memberCount) {
		this.name = team.getName();
		this.manager = manager;
		this.memberCount = memberCount;
	}
}
