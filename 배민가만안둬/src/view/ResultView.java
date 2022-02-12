package view;

public class ResultView {
	public void displayDmlResult(String code) {
		switch(code) {
		case "signupinsertSuccess" : System.out.println("회원 가입에 성공했습니다."); break;
		case "signupinsertFailed" : System.out.println("회원 가입에 실패했습니다."); break;
		case "insertSuccess" : System.out.println("데이터 추가에 성공했습니다."); break;
		case "insertFailed" : System.out.println("데이터 추가에 실패했습니다."); break;
		case "updateSuccess" : System.out.println("데이터 수정에 성공했습니다."); break;
		case "updateFailed" : System.out.println("데이터 수정에 실패했습니다."); break;
		case "deleteSuccess" : System.out.println("데이터 삭제에 성공했습니다."); break;
		case "deleteFailed" : System.out.println("데이터 삭제에 실패했습니다."); break;
		case "selectSuccess" : System.out.println("데이터 조회에 성공했습니다."); break;
		case "selectFailed" : System.out.println("데이터 조회에 실패했습니다."); break;
		default : System.out.println("알 수 없는 에러 발생!"); break;
		}
	}
}
