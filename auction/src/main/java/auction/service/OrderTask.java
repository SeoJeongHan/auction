package auction.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import auction.entity.ProductEntity;

@Component
public class OrderTask {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	
	// 주문 체크
	@SuppressWarnings("deprecation")
	@Scheduled(fixedDelay=1000)
	public void orderSchedule() {
		Date date = new Date();
		String year = date.getYear()+1900+"";
		String month = date.getMonth()+1+"";
		String day = date.getDate()+"";
		String hours = date.getHours()+"";
		String minutes = date.getMinutes()+"";
		String seconds = date.getSeconds()+"";
		String now = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
		
		System.out.println(now);
		
		List<ProductEntity> list = productService.getAll();
		
		for(ProductEntity product : list){
			if(now.equals(product.getP_date2())){
				if(product.getP_b_uid()!=null){
					orderService.orderReg(product);
					productService.deleteProduct(product);
				}else{
					productService.deleteProduct(product);
				}
			}else
			{
				
			}
		}
	}
}
