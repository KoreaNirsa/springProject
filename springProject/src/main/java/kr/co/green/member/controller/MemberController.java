package kr.co.green.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import kr.co.green.member.dto.MemberDTO;
import kr.co.green.member.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;

//    /member/register/form -> 회원가입 페이지(GET)
//    /member/register  -> 회원가입 요청(POST)
//    /member/login/form  -> 로그인 페이지(GET)
//    /member/login  -> 로그인 요청(POST)
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	private final MemberServiceImpl memberService;
	
	@GetMapping("/register/form")
	public String registerForm(Model model) {
		model.addAttribute("memberDTO", new MemberDTO());
		return "member/register";
	}
	
	@PostMapping("/register")
	public String register(@Valid MemberDTO memberDTO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("bindingResult", bindingResult); // 생략 가능
			return "member/register";
		}
		
		int result = memberService.register(memberDTO);
		return "redirect:/member/login/form";
	}
	
	// 로그인 페이지 이동 ->    /member/login/form
	@GetMapping("/login/form")
	public String loginForm() {
		return "member/login";
	}
	
//	private int memberId;
//	private String id;
//	private String name;
//	private String password;
	@PostMapping("/login")
	public String login(MemberDTO memberDTO, HttpSession session) {
		MemberDTO result = memberService.login(memberDTO);
		
		if(result != null) {
			session.setAttribute("memberId", result.getMemberId());
			session.setAttribute("id", result.getId());
			session.setAttribute("name", result.getName());
			session.setAttribute("status", result.getStatus());
			return "redirect:/";
		}
		
		return "redirect:/member/login/form";
	}
	
	// 1. 사용자 요청 (/member/login) -> 서버
	// 2. 서버는 URL이 매핑되는 컨트롤러가 있는지 확인하고 있다면 컨트롤러로 감
	// 3. 컨트롤러는 사용자가 요청한 데이터를 받고, 서비스를 호출
	// 4. 서비스는 로직이 있다면 로직을 처리하고, 매퍼를 호출
	
	// 5. 매퍼의 반환값이 1이다, 서비스로 반환
	// 6. 서비스가 반환값을 컨틀로러로 반환
	// 7. 컨트롤러는 View(타임리프)로 넘겨주고
	
	// 8.변수같은것들을 순수 hmtl로 변환
	// 9. 이제서야 사용자에게 html 파일 전달(응답)
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 무효화
		return "redirect:/";
	}
	
}














