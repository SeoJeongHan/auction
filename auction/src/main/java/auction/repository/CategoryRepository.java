package auction.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import auction.entity.CategoryEntity;

@Component
public class CategoryRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//Category용 rowMapper 정의
	class CategoryRowMapper implements RowMapper<CategoryEntity>{
		public CategoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			CategoryEntity category = new CategoryEntity();
			category.setCcode((rs.getString("c_code")));
			category.setCname((rs.getString("c_name")));
			category.setCcount((rs.getInt("c_count")));
			return category;
		}
	}
	
	//Category용 rowMapper 생성
	CategoryRowMapper rowMapper = new CategoryRowMapper();
	
	// 카테고리 가져오기
	public void getCategory(String c_code, Model model) {
		String sql = "SELECT * FROM TBL_CATEGORY WHERE C_CODE = ?";
		try{
			model.addAttribute("category", jdbcTemplate.queryForObject(sql, rowMapper, c_code));
		}catch(Exception e){
			model.addAttribute("category", null);
		}
	}

	// 카테고리 조회수 증가
	public void countUp(String c_code) {
		String sql="UPDATE TBL_CATEGORY SET C_COUNT = C_COUNT+1 WHERE C_CODE=?";
		jdbcTemplate.update(sql, c_code);
	}

	// 카테고리 순위 가져오기
	public void getCategoryList(Model model) {
		String sql = "SELECT * FROM TBL_CATEGORY ORDER BY C_COUNT DESC";
		try{
			model.addAttribute("categoryList", jdbcTemplate.query(sql, rowMapper));
		}catch(Exception e){
			model.addAttribute("categoryList", null);
		}
	}
}
