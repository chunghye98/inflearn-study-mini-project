package inflearn.study.company.domain.member;

import java.time.LocalDate;

import inflearn.study.company.domain.team.Team;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Enumerated(EnumType.STRING)
	private Role role;

	private LocalDate birthday;
	private LocalDate workStartDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

	public Member() {
	}

	public Member(String name, boolean isManager, LocalDate birthday, LocalDate workStartDate) {
		this.name = name;
		this.role = Role.findRole(isManager);
		this.birthday = birthday;
		this.workStartDate = workStartDate;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public LocalDate getWorkStartDate() {
		return workStartDate;
	}

	public Team getTeam() {
		return team;
	}
}
