package auction.entity;

import org.springframework.stereotype.Component;

@Component
public class CategoryEntity {
	private String ccode;	// 브랜드 코드
	private String cname;	// 브랜드 이름
	private int ccount;		//	브랜드 조회수
	
	public CategoryEntity() {
		super();
	}
	
	public CategoryEntity(String ccode, String cname, int ccount) {
		super();
		this.ccode = ccode;
		this.cname = cname;
		this.ccount = ccount;
	}

	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCcount() {
		return ccount;
	}
	public void setCcount(int ccount) {
		this.ccount = ccount;
	}
	
}
