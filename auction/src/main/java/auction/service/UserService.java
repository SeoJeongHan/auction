package auction.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import auction.entity.UserEntity;
import auction.repository.UserRepository;

@Component
public class UserService {
	@Autowired
	private UserRepository userRepository;

	// 로그인
	public void login(String id, String password, HttpSession session) {
		userRepository.login(id, password, session);
	}

	// 비밀번호 찾기
	public void searchPass(String id, String name, String phone, Model model) {
		userRepository.sarchPass(id, name, phone, model);
	}
	
	// 가입
	public void userReg(UserEntity userEntity) {
		userRepository.userReg(userEntity);
	}

	// 정보보기
	public void showInfo(String id, Model model) {
		userRepository.showInfo(id, model);
	}

	// 정보수정
	public UserEntity updateUser(UserEntity user) {
		return userRepository.updateUser(user);
	}

	// 중복체크
	public boolean idCheck(String id) {
		return userRepository.idCheck(id);
	}

	// 판매자, 구매자 정보 보기
	public UserEntity getInfo(String id) {
		return userRepository.getInfo(id);
	}
	
}
