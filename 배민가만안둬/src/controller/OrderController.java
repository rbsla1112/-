package controller;

import java.text.SimpleDateFormat;
import java.util.*;

import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderlistDTO;
import service.OrderService;
import view.ResultView;

public class OrderController {
	private OrderService orderService = new OrderService();
	private ResultView rv = new ResultView();

	public List<MenuDTO> selectMenuByOwner(String inputOwner) {
		return orderService.selectMenuByOwner(inputOwner);
	}

	public void registOrder(Map<String, Object> requestMap) {
		int totalOrderPrice = (Integer)requestMap.get("totalOrderPrice");
		String ownerId = (String)requestMap.get("ownerId");
		String customerId = (String)requestMap.get("customerId");
		List<OrderDTO> orderMenuList = (List<OrderDTO>)requestMap.get("orderMenuList");
		
		Date currTime = new Date();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		String orderDateTime = dateTimeFormat.format(currTime);
		
		OrderlistDTO orderList = new OrderlistDTO();
		orderList.setOwnerId(ownerId);
		orderList.setCustomerId(customerId);
		orderList.setOrderDateTime(orderDateTime);
		orderList.setTotalOrderPrice(totalOrderPrice);
		orderList.setOrderMenuList(orderMenuList);
		
		int result = orderService.registOrder(orderList);
		
		if(result > 0) {
			rv.displayDmlResult("orderSuccess");
		} else {
			rv.displayDmlResult("orderFailed");
		}
		
	}

}
