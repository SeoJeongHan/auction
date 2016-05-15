package auction.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import auction.entity.OrderEntity;
import auction.entity.ProductEntity;

@Component
public class OrderRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Order용 rowMapper 정의
	class OrderRowMapper implements RowMapper<OrderEntity> {
		public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderEntity category = new OrderEntity();
			category.setO_code(rs.getString("o_code"));
			category.setO_s_uid(rs.getString("o_s_uid"));
			category.setO_b_uid(rs.getString("o_b_uid"));
			category.setO_snumber(rs.getString("o_snumber"));
			category.setO_sell_price(rs.getInt("o_sell_price"));
			category.setO_date(rs.getString("o_date"));
			return category;
		}
	}

	// Order용 rowMapper 생성
	OrderRowMapper rowMapper = new OrderRowMapper();

	// 과거 낙찰 기록10개 가져오기
	public List<OrderEntity> getOrders(String snumber) {
		String sql = "SELECT * FROM TBL_PRODUCT_ORDER WHERE O_SNUMBER=? ORDER BY O_DATE ASC LIMIT 10";
		try {
			return jdbcTemplate.query(sql, rowMapper, snumber);
		} catch (Exception e) {
			return null;
		}

	}

	// 지난 경매기록 가져오기-판매기록
	public List<OrderEntity> getOrderSoldList(Model model, String o_s_id) {
		String sql = "SELECT * FROM TBL_PRODUCT_ORDER WHERE O_S_UID=? ORDER BY O_DATE DESC LIMIT 10";
		try {
			return jdbcTemplate.query(sql, rowMapper, o_s_id);
		} catch (Exception e) {
			return null;
		}
	}

	// 지난 경매기록 가져오기-구매기록
	public List<OrderEntity> getOrderBoughtList(Model model, String o_b_id) {
		String sql = "SELECT * FROM TBL_PRODUCT_ORDER WHERE O_B_UID=? ORDER BY O_DATE DESC LIMIT 10";
		try {
			return jdbcTemplate.query(sql, rowMapper, o_b_id);
		} catch (Exception e) {
			return null;
		}
	}

	// 주문 처리
	@SuppressWarnings("deprecation")
	public void orderReg(ProductEntity product) {
		String sql = "INSERT INTO TBL_PRODUCT_ORDER(o_s_uid, o_b_uid, o_snumber, o_sell_price, o_date) VALUES(?,?,?,?,?)";
		String sql2 = "UPDATE TBL_USER SET U_POINT = U_POINT+? WHERE U_ID=?";
		
		Date date = new Date();
		String year = date.getYear() + 1900 + "";
		String month = date.getMonth() + 1 + "";
		String day = date.getDate() + "";
		String hours = date.getHours() + "";
		String minutes = date.getMinutes() + "";
		String seconds = date.getSeconds() + "";
		final String now = year + "-" + month + "-" + day + " " + hours + ":"
				+ minutes + ":" + seconds;
		
		try {
			jdbcTemplate.update(sql, product.getP_s_uid(),
					product.getP_b_uid(), product.getP_snumber(),
					product.getP_current_price(), now);
			jdbcTemplate.update(sql2, product.getP_current_price() * 0.1,
					product.getP_s_uid());
			System.out.println(product.getP_code() + " - 주문 정상처리됨");
		} catch (Exception e) {
		}
	}

	// 평균
	public int getAvg(String snum) {
		List<OrderEntity> olist;
		try {
			olist = jdbcTemplate.query(
					"SELECT * FROM TBL_PRODUCT_ORDER WHERE O_SNUMBER=?",
					rowMapper, snum);
		} catch (Exception e) {
			olist = null;
		}

		int sum = 0;
		int count = 0;
		int avg = 0;
		
		for (OrderEntity o : olist) {
			count++;
			sum += o.getO_sell_price();
		}
		
		if (count != 0) {
			avg = sum / count;
		} else {
			avg = 0;
		}
		return avg;

	}

	// 맥스
	public int getMax(String snum) {
		int max=0;
		try {
			max=jdbcTemplate.queryForInt("SELECT O_SELL_PRICE FROM TBL_PRODUCT_ORDER WHERE O_SNUMBER=? ORDER BY O_SELL_PRICE DESC LIMIT 1",snum);
		} catch (Exception e) {
			max=0;
		}
		return max;
	}

	// 미니멈
	public int getMin(String snum) {
		int min=0;
		try {
			min=jdbcTemplate
					.queryForInt(
							"SELECT O_SELL_PRICE FROM TBL_PRODUCT_ORDER WHERE O_SNUMBER=? ORDER BY O_SELL_PRICE ASC LIMIT 1",
							snum);
		} catch (Exception e) {
			min=0;
		}
		return min;
	}

}
