package inflearn.study.company.domain.team;

import java.util.ArrayList;
import java.util.List;

import inflearn.study.company.domain.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();

	protected Team() {

	}

	public Team(String name) {
		this.name = name;
	}

	public void addMember(Member member) {
		this.members.add(member);
		member.setTeam(this);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Member> getMembers() {
		return members;
	}
}
