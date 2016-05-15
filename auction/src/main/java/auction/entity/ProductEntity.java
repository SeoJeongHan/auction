package auction.entity;

import org.springframework.stereotype.Component;

@Component
public class ProductEntity {

	private int p_code; 			// 상품 코드
	private String p_s_uid;			// 파는사람 아이디
	private String p_b_uid;			// 산사람 아이디
	private String p_category;	// 브랜드 코드
	private String p_snumber;		// 제품번호
	private int p_instant_price;	// 즉시구매가
	private int p_primary_price;	// 초기 가격
	private int p_current_price;	// 현재 가격
	private String p_content;		// 상품 설명
	private String p_title;			// 상품 제목
	private String p_date;			// 등록시간
	private String p_date2;		// 종료시간

	
	public ProductEntity() {}
	
	public int getP_code() {
		return p_code;
	}

	public void setP_code(int p_code) {
		this.p_code = p_code;
	}

	public String getP_s_uid() {
		return p_s_uid;
	}

	public void setP_s_uid(String p_s_uid) {
		this.p_s_uid = p_s_uid;
	}

	public String getP_b_uid() {
		return p_b_uid;
	}

	public void setP_b_uid(String p_b_uid) {
		this.p_b_uid = p_b_uid;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getP_snumber() {
		return p_snumber;
	}

	public void setP_snumber(String p_snumber) {
		this.p_snumber = p_snumber;
	}

	public int getP_instant_price() {
		return p_instant_price;
	}

	public void setP_instant_price(int p_instant_price) {
		this.p_instant_price = p_instant_price;
	}
	
	public int getP_primary_price() {
		return p_primary_price;
	}

	public void setP_primary_price(int p_primary_price) {
		this.p_primary_price = p_primary_price;
	}

	public int getP_current_price() {
		return p_current_price;
	}

	public void setP_current_price(int p_current_price) {
		this.p_current_price = p_current_price;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}

	public String getP_date2() {
		return p_date2;
	}

	public void setP_date2(String p_date2) {
		this.p_date2 = p_date2;
	}


	public ProductEntity(int p_code, String p_s_uid, String p_b_uid,
			String p_category, String p_snumber, int p_instant_price,
			int p_primary_price, int p_current_price, String p_content,
			String p_title, String p_date, String p_date2) {
		this.p_code = p_code;
		this.p_s_uid = p_s_uid;
		this.p_b_uid = p_b_uid;
		this.p_category = p_category;
		this.p_snumber = p_snumber;
		this.p_instant_price = p_instant_price;
		this.p_primary_price = p_primary_price;
		this.p_current_price = p_current_price;
		this.p_content = p_content;
		this.p_title = p_title;
		this.p_date = p_date;
		this.p_date2 = p_date2;

	}

	

}
