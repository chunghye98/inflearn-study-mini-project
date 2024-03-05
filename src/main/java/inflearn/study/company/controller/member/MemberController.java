package inflearn.study.company.controller.member;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inflearn.study.company.dto.request.member.MemberCreateRequest;
import inflearn.study.company.dto.response.member.MemberReadResponse;
import inflearn.study.company.service.member.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {

	private final MemberService memberService;

	/**
	 * 직원 등록
	 * @param request
	 */
	@PostMapping("/member")
	public void createMember(@RequestBody MemberCreateRequest request) {
		memberService.createMember(request);
	}

	/**
	 * 직원 조회
	 * @return
	 */
	@GetMapping("/member")
	public List<MemberReadResponse> getAllMembers() {
		return memberService.getAllMembers();
	}
}
