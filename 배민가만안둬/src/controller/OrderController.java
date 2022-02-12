package controller;

import java.util.List;

import model.dto.MenuDTO;
import service.OrderService;

public class OrderController {
	private OrderService orderService = new OrderService();

	public List<MenuDTO> selectMenuByOwner(String inputOwner) {
		return orderService.selectMenuByOwner(inputOwner);
	}

}
