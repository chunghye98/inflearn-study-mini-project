package inflearn.study.company.dto.request.member;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberCreateRequest {

	private String name;

	private Boolean isManager;

	private LocalDate birthday;
	private LocalDate workStartDate;

	private Long teamId;

	public String getName() {
		return name;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public LocalDate getWorkStartDate() {
		return workStartDate;
	}

	public Long getTeamId() {
		return teamId;
	}
}
