package auction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import auction.entity.OrderEntity;
import auction.entity.ProductEntity;
import auction.repository.OrderRepository;

@Component
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	// 과거 낙찰 기록 가져오기
	public List<OrderEntity> getOrders(String snumber) {
		return orderRepository.getOrders(snumber);
	}
	
	// 지난 경매기록 가져오기-판매기록
	public List<OrderEntity> getOrderSoldList(Model model, String o_s_id) {
		return orderRepository.getOrderSoldList(model, o_s_id);
	}

	// 지난 경매기록 가져오기-구매기록
	public List<OrderEntity> getOrderBoughtList(Model model, String o_b_id) {
		return orderRepository.getOrderBoughtList(model, o_b_id);
	}

	// 주문 처리
	public void orderReg(ProductEntity product) {
		orderRepository.orderReg(product);
	}

	// 평균
	public int getAvg(String snum) {
		return orderRepository.getAvg(snum);
	}

	// 맥스
	public int getMax(String snum) {
		return orderRepository.getMax(snum);
	}

	// 미니멈
	public int getMin(String snum) {
		return orderRepository.getMin(snum);
	}

}
