package auction.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import auction.entity.UserEntity;

@Component
public class UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// user 용 rowMapper 정의, 생성
	private UserRowMapper rowMapper = new UserRowMapper();

	private class UserRowMapper implements RowMapper<UserEntity> {
		public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new UserEntity(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getInt(8));
		}
	}

	// 회원가입
	public void userReg(UserEntity userEntity) {
		String sql = "INSERT INTO TBL_USER(U_ID, U_PASS, U_NAME, U_ADDR, U_PHONE, U_EMAIL, U_GENDER, U_POINT) VALUES(?, ?, ?, ?, ?,?,?,?)";
		jdbcTemplate.update(sql, userEntity.getId(), userEntity.getPassword(),
				userEntity.getName(), userEntity.getAddress(),
				userEntity.getPhone(), userEntity.getEmail(),
				userEntity.getGender(), 0);
	}

	// 로그인
	public void login(String id, String password, HttpSession session) {
		UserEntity loginUser;
		try {
			String sql = "SELECT * FROM TBL_USER WHERE U_ID=? AND U_PASS=?";
			loginUser = jdbcTemplate.queryForObject(sql, rowMapper, id,
					password);
		} catch (Exception e) {
			loginUser = null;
		}
		session.setAttribute("loginUser", loginUser);
	}

	// 비밀번호 찾기
	public void sarchPass(String id, String name, String phone, Model model) {
		String pass;
		try {
			String sql = "SELECT * FROM TBL_USER WHERE U_ID=? AND U_NAME=? AND U_PHONE=?";
			pass = jdbcTemplate.queryForObject(sql, new RowMapper<String>() {
				public String mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					return rs.getString("u_name") + "님의 비밀번호는 "
							+ rs.getString("u_pass") + " 입니다.";
				}
			}, id, name, phone);
		} catch (Exception e) {
			pass = "아이디/이름/전화번호 확인해주세요";
		}
		model.addAttribute("pass", pass);
	}

	// 자기정보보기
	public void showInfo(String id, Model model) {
		String sql = "SELECT * FROM TBL_USER WHERE U_ID=?";
		try {
			model.addAttribute("user",
					jdbcTemplate.queryForObject(sql, rowMapper, id));
		} catch (Exception e) {
			model.addAttribute("user", null);
		}
	}

	// 정보수정
	public UserEntity updateUser(UserEntity user) {
		String sql = "UPDATE TBL_USER SET U_ADDR=?, U_PHONE=?, U_EMAIL=? WHERE U_ID=?";
		jdbcTemplate.update(sql, user.getAddress(), user.getPhone(), user.getEmail(), user.getId());
		String sql2 = "SELECT * FROM TBL_USER WHERE U_ID=?";
		try{
			return jdbcTemplate.queryForObject(sql2, rowMapper, user.getId());
		}catch(Exception e){
			return null;
		}
	}

	// ID 중복체크
	public boolean idCheck(String id) {
		String sql = "SELECT COUNT(*) FROM TBL_USER WHERE U_ID=?";
		int count = jdbcTemplate.queryForInt(sql, id);
		if(count==0){
			return true;
		}else{
			return false;
		}
	}

	// 유저 가져오기
	public UserEntity getInfo(String id) {
		String sql = "SELECT * FROM TBL_USER WHERE U_ID=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
}
