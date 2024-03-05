package inflearn.study.company.dto.request.member;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class MemberCreateRequest {
	private String name;
	private Boolean isManager;
	private LocalDate birthday;
	private LocalDate workStartDate;
	private Long teamId;
}
