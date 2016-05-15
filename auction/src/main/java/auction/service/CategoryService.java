package auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import auction.repository.CategoryRepository;

@Component
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	// 카테고리 가져오기
	public void getCategory(String c_code, Model model) {
		categoryRepository.getCategory(c_code, model);
	}

	// 카테고리 조회수 증가
	public void countUp(String c_code) {
		categoryRepository.countUp(c_code);
	}

	// 카테고리 순위 가져오기
	public void getCategoryList(Model model) {
		categoryRepository.getCategoryList(model);
	}
}
