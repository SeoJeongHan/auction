package auction.entity;

import org.springframework.stereotype.Component;

@Component
public class OrderEntity {
	private String o_code;
	private String o_s_uid;
	private String o_b_uid;
	private String o_snumber;
	private int o_sell_price;
	private String o_date;
	private double x;
	private double y;
	
	public OrderEntity(){}
	
	public OrderEntity(String o_code, String o_s_uid, String o_b_uid,
			String o_snumber, int o_sell_price, String o_date, double x,
			double y) {
		this.o_code = o_code;
		this.o_s_uid = o_s_uid;
		this.o_b_uid = o_b_uid;
		this.o_snumber = o_snumber;
		this.o_sell_price = o_sell_price;
		this.o_date = o_date;
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}



	public String getO_code() {
		return o_code;
	}
	public void setO_code(String o_code) {
		this.o_code = o_code;
	}
	public String getO_s_uid() {
		return o_s_uid;
	}
	public void setO_s_uid(String o_s_uid) {
		this.o_s_uid = o_s_uid;
	}
	public String getO_b_uid() {
		return o_b_uid;
	}
	public void setO_b_uid(String o_b_uid) {
		this.o_b_uid = o_b_uid;
	}
	public String getO_snumber() {
		return o_snumber;
	}
	public void setO_snumber(String o_snumber) {
		this.o_snumber = o_snumber;
	}
	public int getO_sell_price() {
		return o_sell_price;
	}
	public void setO_sell_price(int o_sell_price) {
		this.o_sell_price = o_sell_price;
	}
	public String getO_date() {
		return o_date;
	}
	public void setO_date(String o_date) {
		this.o_date = o_date;
	}
	
	
}