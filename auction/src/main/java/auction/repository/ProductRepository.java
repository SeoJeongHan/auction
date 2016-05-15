package auction.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.mysql.jdbc.Statement;

import auction.entity.ProductEntity;
import auction.entity.UserEntity;

@Component
public class ProductRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// product 용 rowMapper 정의, 생성
	private ProductRowMapper rowMapper = new ProductRowMapper();

	private class ProductRowMapper implements RowMapper<ProductEntity> {
		public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new ProductEntity(rs.getInt(1), rs.getString(2), rs.getString(3), 
												rs.getString(4), rs.getString(5), rs.getInt(6), 
												rs.getInt(7), rs.getInt(8), rs.getString(9), 
												rs.getString(10), rs.getString(11), rs.getString(12));
		}
	}

	// 물품 등록
	@SuppressWarnings("deprecation")
	public Number productReg(final UserEntity seller, final ProductEntity productSellForm, final int time) {
		Date date = new Date();
		String year = date.getYear() + 1900 + "";
		String month = date.getMonth() + 1 + "";
		String day = date.getDate() + "";
		String hours = date.getHours() + "";
		String minutes = date.getMinutes() + "";
		String seconds = date.getSeconds() + "";
		final String now = year + "-" + month + "-" + day + " " + hours + ":"
				+ minutes + ":" + seconds;

		productSellForm.setP_date(now);
		if (Integer.parseInt(hours) + time >= 24) {
			hours = Integer.toString((Integer.parseInt(hours) + time) - 24);
			day = Integer.toString(Integer.parseInt(day) + 1);
		} else {
			hours = Integer.toString(Integer.parseInt(hours) + time);
		}

		final String sellDate = year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
		productSellForm.setP_date2(sellDate);
		
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "INSERT INTO TBL_PRODUCT_LIST"
						+ "(P_S_UID, P_CATEGORY, P_SNUMBER, P_INSTANT_PRICE,"
						+ " P_PRIMARY_PRICE, P_CURRENT_PRICE, P_CONTENT, P_TITLE, P_DATE, P_DATE2)"
						+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement temp = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				temp.setString(1, seller.getId());
				temp.setString(2, productSellForm.getP_category());
				temp.setString(3, productSellForm.getP_snumber());
				temp.setInt(4, productSellForm.getP_instant_price());
				temp.setInt(5, productSellForm.getP_primary_price());
				temp.setInt(6, productSellForm.getP_primary_price());
				temp.setString(7, productSellForm.getP_content());
				temp.setString(8, productSellForm.getP_title());
				temp.setString(9, now);
				temp.setString(10, sellDate);
				
				temp.getGeneratedKeys();
				return temp;
			}
		}, keyHolder);
		
		productSellForm.setP_code(keyHolder.getKey().intValue());
		return keyHolder.getKey();
	}

	// 등록 물품 9개 가져오기
	public List<ProductEntity> findNineProduct() {
		String sql = "SELECT * FROM TBL_PRODUCT_LIST ORDER BY P_DATE DESC LIMIT 9";
		try {
			return jdbcTemplate.query(sql, rowMapper);
		} catch (Exception e) {
			return null;
		}
	}

	// 카테고리별 등록 물품 가져오기
	public void categoryLink(String c_code, Model model) {
		String sql = "SELECT * FROM TBL_PRODUCT_LIST WHERE P_CATEGORY = ?";
		try {
			model.addAttribute("clist", jdbcTemplate.query(sql, rowMapper, c_code));
		} catch (Exception e) {
			model.addAttribute("clist", null);
		}
	}

	// 상세정보 조회
	public boolean getProduct(Model model, String p_code) {
		String sql = "SELECT *  FROM TBL_PRODUCT_LIST WHERE P_CODE=?";
		try {
			model.addAttribute("ProductEntity", jdbcTemplate.queryForObject(sql, rowMapper, p_code));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 제목, 내용, 모델명 검색
	public List<ProductEntity> searchList(String searchText) {
		String sql = "SELECT * FROM TBL_PRODUCT_LIST WHERE P_TITLE LIKE ? OR P_CONTENT LIKE ? OR P_SNUMBER LIKE ?";
		try {
			return jdbcTemplate.query(sql, rowMapper, "%" + searchText + "%", "%" + searchText + "%", "%" + searchText + "%");
		} catch (Exception e) {
			return null;
		}
	}

	// 가격 입찰
	public void updatePrice(String pCode, String cPrice_new) {
		String sql = "UPDATE TBL_PRODUCT_LIST SET P_CURRENT_PRICE = ? WHERE P_CODE = ?";
		try {
			jdbcTemplate.update(sql, cPrice_new, pCode);
		} catch (Exception e) {

		}
	}

	// 구매자 추가
	public void addBid(String pCode, UserEntity loginUser) {
		String sql = "UPDATE TBL_PRODUCT_LIST SET P_B_UID = ? WHERE P_CODE = ?";
		try{
			jdbcTemplate.update(sql, loginUser.getId(), pCode);
		}catch(Exception e){}
	}

	// 상품판매내역가져오기
	public List<ProductEntity> getProductSellList(String p_s_uid, Model model) {
		String sql = "SELECT * FROM TBL_PRODUCT_LIST WHERE P_S_UID=? ORDER BY P_DATE DESC";
		try {
			return jdbcTemplate.query(sql, rowMapper, p_s_uid);
		} catch (Exception e) {
			return null;
		}
	}

	// 상품 구매내역 가져오기
	public List<ProductEntity> getProductBuyList(String p_b_uid, Model model) {
		String sql = "SELECT * FROM TBL_PRODUCT_LIST WHERE P_B_UID=? ORDER BY P_DATE DESC";
		try {
			return jdbcTemplate.query(sql, rowMapper, p_b_uid);
		} catch (Exception e) {
			return null;
		}
	}

	// 상품 가져오기
	public ProductEntity getProduct(String p_code) {
		String sql = "SELECT *  FROM TBL_PRODUCT_LIST WHERE P_CODE=?";
		try {
			return jdbcTemplate.queryForObject(sql, rowMapper, p_code);
		} catch (Exception e) {
			return null;
		}
	}

	// 모든 상품 불러오기
	public List<ProductEntity> getAll() {
		String sql = "SELECT * FROM TBL_PRODUCT_LIST";
		try{
			return jdbcTemplate.query(sql, rowMapper);
		}catch(Exception e){
			return null;
		}
	}
	
	// 등록 상품 삭제
	public void deleteProduct(ProductEntity product) {
		String sql = "DELETE FROM TBL_PRODUCT_LIST WHERE P_CODE=?";
		jdbcTemplate.update(sql, product.getP_code());
		System.out.println(product.getP_code()+" - 삭제됨");
	}
}
