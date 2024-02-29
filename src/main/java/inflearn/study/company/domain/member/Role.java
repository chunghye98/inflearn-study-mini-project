package inflearn.study.company.domain.member;

public enum Role {
	MEMBER, MANAGER;

	public static Role findRole(boolean isManager) {
		if(isManager) {
			return MANAGER;
		}
		return MEMBER;
	}
}
