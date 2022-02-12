package view;

import java.util.*;

import controller.CustomerController;
import controller.OrderController;
import controller.OwnerController;
import model.dto.MenuDTO;
import model.dto.OrderDTO;
import model.dto.OwnerDTO;

public class OrderMenu {
	private Scanner sc = new Scanner(System.in);
	
	private OrderController orc = new OrderController();
	private CustomerController cc = new CustomerController();
	private OwnerController owc = new OwnerController();
	
	public void displayMenu() {
		do {
			System.out.println("----- 배민 가만안둬 -----");
			System.out.println("1. 고객 메뉴");
			System.out.println("2. 사장님 메뉴");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			sc.nextLine();
			
			switch(no) {
			case 1 : displayCustomerLogin(); break;
			case 2 : displayOwnerLogin(); break;
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
			}
		} while(true);
	}
	
	public void displayCustomerLogin() {
		do {
			System.out.println("----- 고객 메뉴 -----");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 뒤로 가기");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			sc.nextLine();
			
			switch(no) {
			case 1 : 
				String inputId = inputId();
				int result = cc.customerLogin(inputId, inputPwd());
				if(result == 1) {
					displayCustomerMenu(inputId); break;
				} else {
					break;
				}
			case 2 : cc.customerSignup(inputId(), inputPwd()); break;
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
			}
		} while(true);
	}
	
	public void displayOwnerLogin() {
		do {
			System.out.println("----- 사장님 메뉴 -----");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 뒤로 가기");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			sc.nextLine();
			
			switch(no) {
			case 1 :
				String inputId = inputId();
				int result = owc.ownerLogin(inputId, inputPwd());
				
				if(result ==1) {
					displayManageMenu(inputId); break;
				} else {
					break;
				}
			case 2 : owc.ownerSignup(inputId(), inputPwd()); break;
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
			}
		} while(true);
	}
	
	public String inputId() {
		System.out.print("아이디 입력 : ");
		return sc.nextLine();
	}
	
	public String inputPwd() {
		System.out.print("비밀번호 입력 : ");
		return sc.nextLine();
	}
	
	public void displayCustomerMenu(String id) {
		do {
			System.out.println("----- 고객 메뉴 -----");
			System.out.println("1. 주문");
			System.out.println("2. 프로필 관리");
			System.out.println("0. 뒤로 가기");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			sc.nextLine();
			
			switch(no) {
			case 1 : displayOrderMenu(id); break;
			case 2 : displayCProfileMenu(id); break;
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
			}
		} while(true);
	}
	
	public void displayOrderMenu(String id) {
		List<OrderDTO> orderMenuList = new ArrayList<>();
		int totalOrderPrice = 0;
		String inputOwner = "";
		
		System.out.println("----- 주문 -----");
		
		System.out.println("----- 주문 가능 식당 -----");
		// 식당 목록 보여주기
		List<OwnerDTO> ownerList = owc.selectAllOwner();
		// 아이디(상호명)만 출력
		for(OwnerDTO owner : ownerList) {
			System.out.println(owner.getOwnerId());
		}
		
		System.out.print("주문하실 식당을 선택해주세요 : ");
		inputOwner = sc.nextLine();
		
		do {
			System.out.println("----- 주문 가능 메뉴 -----");
			List<MenuDTO> menuList = orc.selectMenuByOwner(inputOwner);
			for(MenuDTO menu : menuList) {
				System.out.println(menu.getMenuName() + "     \t" + menu.getMenuPrice());
			}
			
			System.out.print("주문하실 메뉴를 선택해주세요 : ");
			String inputMenu = sc.nextLine();
			
			int menuCode = 0;
			int menuPrice = 0;
			
			for(int i = 0; i < menuList.size(); i++) {
				MenuDTO menu = menuList.get(i);
				if(menu.getMenuName().equals(inputMenu)) {
					menuCode = menu.getMenuCode();
					menuPrice = menu.getMenuPrice();
				}
			}
			
			System.out.print("주문하실 수량을 입력해주세요 : ");
			int orderAmount = sc.nextInt();
			
			OrderDTO orderMenu = new OrderDTO();
			orderMenu.setMenuCode(menuCode);
			orderMenu.setAmount(orderAmount);
			
			orderMenuList.add(orderMenu);
			totalOrderPrice += (menuPrice * orderAmount);
			
			System.out.print("계속 주문하시겠습니까?(예/아니오) : ");
			sc.nextLine();
			boolean isContinue = sc.nextLine().equals("예") ? true : false;
			
			if(!isContinue) break;
		} while(true);
		
		for(OrderDTO orderMenu : orderMenuList) {
			System.out.println(orderMenu);
		}
		
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("totalOrderPrice", totalOrderPrice);
		requestMap.put("orderMenuList", orderMenuList);
		requestMap.put("ownerId", inputOwner);
		requestMap.put("customerId", id);
		
		orc.registOrder(requestMap);
	}
	
	public void displayCProfileMenu(String id) {
		do {
			System.out.println("----- 프로필 관리 -----");
			System.out.println(id + "님");
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 주문내역 조회");
			System.out.println("3. 회원 탈퇴");
			System.out.println("0. 뒤로 가기");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			sc.nextLine();
			
			switch(no) {
			case 1 : cc.modifyPassword(id, inputPwd()); displayCustomerLogin();
			case 2 : cc.selectOrderHistory(id); break;
			case 3 : cc.deleteCustomer(id); displayCustomerLogin();
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
			}
		} while(true);
	}
	
	public void displayManageMenu(String id) {
		do {
	        System.out.println("----- 사장님 메뉴 -----");
	        System.out.println(id);
	        System.out.println("1. 메뉴 추가");
	        System.out.println("2. 메뉴 수정");
	        System.out.println("3. 메뉴 삭제");
	        System.out.println("4. 비밀번호 수정");
	        System.out.println("0. 돌아가기 ");
	        System.out.print("메뉴 선택 : ");
	        int no = sc.nextInt();
	        sc.nextLine();

	        switch(no) {
	        case 1 : owc.createNewMenu(inputMenu(), inputPrice()); break;
	        case 2 : owc.modifyMenu(inputMenu(), inputPrice(), id); break;
	        case 3 : owc.deleteMenu(inputMenu()); break;
	        case 4 : owc.modifyPassword(id, inputPwd()); displayOwnerLogin();
	        case 0 : return;
	        default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
	        }
	    } while(true);
	}
	
	public String inputMenu() {
		System.out.print("메뉴 이름 입력 : ");
		return sc.nextLine();
	}
	
	public int inputPrice() {
		System.out.print("메뉴 가격 입력 : ");
		return sc.nextInt();
	}
}
