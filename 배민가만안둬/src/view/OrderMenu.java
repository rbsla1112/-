package view;

import java.util.*;

import controller.CustomerController;
import controller.OrderController;
import controller.OwnerController;
import model.dto.MenuDTO;
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
			case 1 : displayCustomerMenu(); break;
			case 2 : displayOwnerMenu(); break;
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
			}
		} while(true);
	}
	
	public void displayCustomerMenu() {
		do {
			System.out.println("----- 고객 메뉴 -----");
			System.out.println("1. 주문");
			System.out.println("2. 프로필 관리");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			sc.nextLine();
			
			switch(no) {
			case 1 : displayOrderMenu(); break;
			case 2 : displayCProfileMenu(); break;
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
			}
		} while(true);
	}
	
	public void displayOwnerMenu() {
		do {
			System.out.println("----- 사장님 메뉴 -----");
			System.out.println("1. 식당 관리");
			System.out.println("2. 프로필 관리");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			sc.nextLine();
			
			switch(no) {
			case 1 : displayManageMenu(); break;
			case 2 : displayOProfileMenu(); break;
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
			}
		} while(true);
	}
	
	public void displayOrderMenu() {
		do {
			System.out.println("----- 주문 -----");
			
			System.out.println("----- 주문 가능 식당 -----");
			// 식당 목록 보여주기
			List<OwnerDTO> ownerList = owc.selectAllOwner();
			// 아이디(상호명)만 출력
			for(OwnerDTO owner : ownerList) {
				System.out.println(owner.getOwnerId());
			}
			
			System.out.println();
			System.out.print("주문하실 식당을 선택해주세요 : ");
			String inputOwner = sc.nextLine();
			
			System.out.println("----- 주문 가능 메뉴 -----");
			List<MenuDTO> menuList = orc.selectMenuByOwner(inputOwner);
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} while(true);
	}
	
	public void displayCProfileMenu() {
		
	}
	
	public void displayManageMenu() {
		
	}
	
	public void displayOProfileMenu() {
		
	}

}
