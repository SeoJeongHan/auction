package auction.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import auction.entity.UserEntity;
import auction.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// 로그인 처리
	@RequestMapping("loginProc")
	public String loginProc(@RequestParam(value = "id") String id, @RequestParam(value = "password") String password, HttpSession session, Model model) {
		userService.login(id, password, session);
		if (session.getAttribute("loginUser") != null) {
			return "forward:/index";
		} else {
			model.addAttribute("fail", ": 비밀번호를 확인해주세요.");
			return "/loginPage";
		}
	}

	// 비밀번호 찾기
	@RequestMapping("searchPassProc")
	public String searchPassProc(@RequestParam("id") String id, String name, String phone, Model model) {
		userService.searchPass(id, name, phone, model);
		return "forward:/searchPass";
	}

	// 가입
	@RequestMapping(value="userReg")
	public String userReg(@ModelAttribute("user")UserEntity user, Model model){
		if(user.getPassword().equals(user.getPasswordChk())){
			userService.userReg(user);
			model.addAttribute("userEntity", user);
			return "/userRegResult";
		}else{
			model.addAttribute("regFail", "비밀번호 확인");
			return "forward:/userReg";
		}
	}
	
	//아이디 중복체크
	@RequestMapping(value="idCheck")
	public String idCheck(@RequestParam(value="id")String id, Model model){
		if(userService.idCheck(id)){
			model.addAttribute("regMsg", "사용 할 수 있는 아이디입니다.");
			model.addAttribute("id", id);
			return "forward:/userRegWrite";
		}
		else{
			model.addAttribute("regMsg", "이미 등록되어 있는 아이디입니다.");
			return "forward:/userRegWrite";
		}
	}

	// 회원정보 수정
	@RequestMapping(value = "userEditProc")
	public String userEditProc(@Valid @ModelAttribute("user") UserEntity user, HttpSession session) {
		if (user.getPassword().equals(userService.getInfo(user.getId()).getPassword())) {
			session.setAttribute("updateMsg", "변경 성공");
			session.setAttribute("loginUser", userService.updateUser(user));
			return "forward:/userEdit";
		} else {
			session.setAttribute("updateMsg", "비밀번호 확인");
			session.setAttribute("loginUser", userService.getInfo(user.getId()));
			return "forward:/userEdit";
		}
	}

	// 판매자, 구매자 정보 보기
	@RequestMapping("userInfo/{id}")
	public String userInfo(@PathVariable String id, Model model) {
		model.addAttribute("user", userService.getInfo(id));
		return "/userInfo";
	}

}
