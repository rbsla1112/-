package controller;

import java.text.SimpleDateFormat;
import java.util.*;

import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OrderlistDTO;
import service.OrderService;

public class OrderController {
	private OrderService orderService = new OrderService();

	public List<MenuDTO> selectMenuByOwner(String inputOwner) {
		return orderService.selectMenuByOwner(inputOwner);
	}

	public void registOrder(Map<String, Object> requestMap) {
		int totalOrderPrice = (Integer)requestMap.get("totalOrderPrice");
		String ownerId = (String)requestMap.get("ownerId");
		String customerId = (String)requestMap.get("customerId");
		List<OrderDTO> orderMenuList = (List<OrderDTO>)requestMap.get("orderMenuList");
		int point = (Integer)requestMap.get("point");
		
		Date currTime = new Date();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		String orderDateTime = dateTimeFormat.format(currTime);
		
		OrderlistDTO orderList = new OrderlistDTO();
		orderList.setOwnerId(ownerId);
		orderList.setCustomerId(customerId);
		orderList.setOrderDateTime(orderDateTime);
		orderList.setTotalOrderPrice(totalOrderPrice);
		orderList.setOrderMenuList(orderMenuList);
		orderList.setPoint(point);
	}

}
