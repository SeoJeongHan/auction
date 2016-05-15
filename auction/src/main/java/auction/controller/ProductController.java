package auction.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import auction.entity.OrderEntity;
import auction.entity.ProductEntity;
import auction.entity.UserEntity;
import auction.service.OrderService;
import auction.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;

	// 경매 등록
	
	@RequestMapping(value = "productRegResult", method = RequestMethod.POST)
	public String productRegResult(@ModelAttribute ProductEntity productSellForm, @RequestParam("time") int time, HttpSession session,@RequestParam("file") MultipartFile file) {
		if (session.getAttribute("loginUser") != null) {
			UserEntity seller = (UserEntity) session.getAttribute("loginUser");
			Number imageNumber = productService.productReg(seller, productSellForm, time);
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					File serverFile = new File("C:\\javawork\\SPRING_WORKSPACE\\auction\\src\\main\\webapp\\images\\" + imageNumber + ".jpg");
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					makeChart(imageNumber+"");
					return "redirect:/index";
				} catch (Exception e) {
					return "You failed to upload " + file.getOriginalFilename()
							+ " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + file.getOriginalFilename()
						+ " because the file was empty.";
			}
		} else {
			return "/loginPage";
		}
	}
	
	// 검색
	@RequestMapping("searchProc")
	public String searchProc(@RequestParam("searchText") String searchText, Model model) {
		model.addAttribute("searchList", productService.searchList(searchText));
		model.addAttribute("searchText", searchText);
		return "searchList";
	}

	// 마이페이지- 진행중인 거래내역 가져오기
	@RequestMapping("myPageIng/{id}")
	public String myPageIng(@PathVariable(value = "id") String id, Model model,HttpSession session) throws Exception {
		if (session.getAttribute("loginUser") != null) {
			List<ProductEntity> productSellList = productService.getProductSellList(model, id);
			List<ProductEntity> productBuyList = productService.getProductBuyList(model, id);
			model.addAttribute("productSellList", productSellList);
			model.addAttribute("productBuyList", productBuyList);
			return "/myPageIng";
		} else {
			return "/loginPage";
		}
	}

	// 마이페이지 - 지난경매기록 불러오기
	@RequestMapping("myPageEnd/{id}")
	public String myPageEnd(@PathVariable(value = "id") String id, Model model,HttpSession session) throws Exception {
		if (session.getAttribute("loginUser") != null) {
			List<OrderEntity> ordersoldList = orderService.getOrderSoldList(model, id);
			List<OrderEntity> orderBoughtList = orderService.getOrderBoughtList(model, id);
			model.addAttribute("orderSoldList", ordersoldList);
			model.addAttribute("orderBoughtList", orderBoughtList);
			return "/myPageEnd";
		} else {
			return "/loginPage";
		}
	}

	// 입찰
	@Transactional
	@RequestMapping("order")
	public String order(@RequestParam String cPrice, String iPrice, String cPrice_new, String pCode, Model model,HttpSession session) throws Exception {
		if (session.getAttribute("loginUser") != null) {
			UserEntity ue = (UserEntity)session.getAttribute("loginUser");
			if(ue.getId().equals(productService.getProduct(pCode).getP_s_uid())){
				model.addAttribute("orderFail", "본인 등록 물품 구매 불가능");
				return "forward:/productDetail/" + pCode;	
			}
			else{	
				if((Integer.parseInt(cPrice_new) >= Integer.parseInt(iPrice))&&(Integer.parseInt(iPrice)!=0)){
					makeChart(pCode);
					productService.updatePrice(pCode, cPrice_new);
					productService.addBid(pCode, (UserEntity) session.getAttribute("loginUser"));
					orderService.orderReg(productService.getProduct(pCode));
					productService.deleteProduct(productService.getProduct(pCode));
					return "forward:/productDetail/" + pCode;
				}else{
					if(Integer.parseInt(cPrice_new) > Integer.parseInt(cPrice)) {
						productService.updatePrice(pCode, cPrice_new);
						productService.addBid(pCode, (UserEntity) session.getAttribute("loginUser"));
					}else{
						model.addAttribute("orderFail", "현재 가격보다 낮음");
					}
					return "forward:/productDetail/" + pCode;
				}
			}
		} else {
			return "/loginPage";
		}
	}

	// 상품 상세 페이지
	@RequestMapping("productDetail/{p_code}")
	public String productDetail(@PathVariable("p_code") String p_code, Model model) throws IOException {
		if(productService.getProduct(model, p_code)){
			int avg = orderService.getAvg(productService.getProduct(p_code).getP_snumber());
			int max = orderService.getMax(productService.getProduct(p_code).getP_snumber());
			int min = orderService.getMin(productService.getProduct(p_code).getP_snumber());
			model.addAttribute("avg", avg);
			model.addAttribute("max", max);
			model.addAttribute("min", min);
		}
		return "/productDetail";
	}
	
	// 전체 목록
	@RequestMapping("getAll")
	public String getAll(Model model){
		model.addAttribute("list", productService.getAll());
		return "/getAll";
	}
	
	// 그래프 만드는 메서드
	public void makeChart(String p_code) throws IOException {
	      final String series1 = p_code;
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	      List<OrderEntity> orderList = orderService.getOrders(productService.getProduct(p_code).getP_snumber());

	      for(OrderEntity order : orderList){
	         String tempTime = order.getO_date().substring(5);
	         int stringIndexNum = tempTime.indexOf(':');
	         stringIndexNum+=3;
	         tempTime = tempTime.substring(0,stringIndexNum);
	         dataset.addValue(order.getO_sell_price(), series1, tempTime);
	      }
	      JFreeChart chart = ChartFactory.createLineChart("Line Chart", "date","price", dataset, PlotOrientation.VERTICAL, true, true, false);
	      chart.setBackgroundPaint(java.awt.Color.white);
	      chart.setTitle(productService.getProduct(p_code).getP_snumber());
	      ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
	      String fileName = "C:\\javawork\\SPRING_WORKSPACE\\auction\\src\\main\\webapp\\chart\\"+productService.getProduct(p_code).getP_snumber() + ".jpeg";
	      ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 800, 300, info);
	   }
}
