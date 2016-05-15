package auction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import auction.entity.ProductEntity;
import auction.entity.UserEntity;
import auction.repository.ProductRepository;

@Component
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	// 등록된 모든 상품 가져오기
	public List<ProductEntity> getAll() {
		return productRepository.getAll();
	}
		
	// 상품 목록 9개 가져오기
	public List<ProductEntity> findNineProducts() {
		return productRepository.findNineProduct();
	}

	// 카테고리별 목록 가져오기
	public void categoryLink(String c_code, Model model) {
		productRepository.categoryLink(c_code, model);
	}

	// 상세페이지
	public boolean getProduct(Model model, String p_code) {
		return productRepository.getProduct(model, p_code);
	}

	// 상품 가져오기
	public ProductEntity getProduct(String p_code) {
		return productRepository.getProduct(p_code);
	}

	// 검색
	public List<ProductEntity> searchList(String searchText) {
		return productRepository.searchList(searchText);
	}

	// 입찰
	public void updatePrice(String pCode, String cPrice_new) {
		productRepository.updatePrice(pCode, cPrice_new);
	}

	// 입찰자 등록
	public void addBid(String pCode, UserEntity loginUser) {
		productRepository.addBid(pCode, loginUser);
	}

	// 상품판매내역 가져오기
	public List<ProductEntity> getProductSellList(Model model, String id) {
		return productRepository.getProductSellList(id, model);
	}

	// 상품구매내역 가져오기
	public List<ProductEntity> getProductBuyList(Model model, String id) {
		return productRepository.getProductBuyList(id, model);
	}

	// 등록
	public Number productReg(UserEntity seller, ProductEntity productSellForm, int time) {
		return productRepository.productReg(seller, productSellForm, time);
	}

	// 등록 지우기
	public void deleteProduct(ProductEntity product) {
		productRepository.deleteProduct(product);
	}

}
