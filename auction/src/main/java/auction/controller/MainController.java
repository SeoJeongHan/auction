package auction.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import auction.entity.ProductEntity;
import auction.entity.UserEntity;
import auction.service.CategoryService;
import auction.service.ProductService;

@Controller
public class MainController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	// 메인 페이지
	@RequestMapping("index")
	public String mainPage(Model model) {
		List<ProductEntity> productList = productService.findNineProducts();
		model.addAttribute("productList", productList);
		categoryService.getCategoryList(model);
		return "/index";
	}

	// 로그인 페이지
	@RequestMapping("loginPage")
	public String goLogin() {
		return "/loginPage";
	}

	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/index";
	}

	// 비밀번호 찾기 페이지
	@RequestMapping("searchPass")
	public String searchPass() {
		return "/searchPass";
	}

	// 약관동의
	@RequestMapping("userAgree")
	public String userAgree(Model model) {
		return "/userAgree";
	}

	// 회원가입 페이지
	@RequestMapping(value = "userRegWrite")
	public String userRegwrite(UserEntity user, Model model) {
		model.addAttribute("user", new UserEntity());
		return "/userReg";
	}

	// 회원정보 수정 페이지
	@RequestMapping(value = "userEdit")
	public String userEdit(Model model, HttpSession session) {
		if(session.getAttribute("loginUser")!=null){
			model.addAttribute("user", session.getAttribute("loginUser"));
			return "/userEdit";
		}else{
			return "/loginPage";
		}
	}

	// 마이 페이지
	@RequestMapping(value = "mypagemain")
	public String mypagemain(Model model, HttpSession session) {
		if(session.getAttribute("loginUser")!=null){
			model.addAttribute("user", session.getAttribute("loginUser"));
			return "/mypagemain";
		}else{
			return "/loginPage";
		}
	}

	// 카테고리 선택 페이지
	@Transactional
	@RequestMapping("category/{c_code}")
	public String categoryLink(@PathVariable("c_code") String c_code,
			Model model) {
		productService.categoryLink(c_code, model);
		categoryService.getCategory(c_code, model);
		categoryService.countUp(c_code);
		return "/categoryList";
	}

	// 경매 등록 페이지
	@RequestMapping("productReg")
	public String productReg(HttpSession session, Model model) {
		if (session.getAttribute("loginUser") != null) {
			model.addAttribute("productSellForm", new ProductEntity());
			return "/productReg";
		} else {
			return "/loginPage";
		}
	}

}
