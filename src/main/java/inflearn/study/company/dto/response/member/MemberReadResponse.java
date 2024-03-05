package inflearn.study.company.dto.response.member;

import java.time.LocalDate;

import inflearn.study.company.domain.member.Member;
import inflearn.study.company.domain.member.Role;
import lombok.Getter;

@Getter
public class MemberReadResponse {

	private String name;
	private String teamName;
	private Role role;
	private LocalDate birthday;
	private LocalDate workStartDate;

	public MemberReadResponse(Member member, String teamName) {
		this.name = member.getName();
		this.teamName = teamName;
		this.role = member.getRole();
		this.birthday = member.getBirthday();
		this.workStartDate = member.getWorkStartDate();
	}
}
