package Team_project2_fin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Controller {
	View view = new View();
	DAO dao = new DAO();
	VO vo = new VO();
	Scanner sc = new Scanner(System.in);

	VO[] infoRest = new VO[10];
	VO[] infoCate = new VO[4];
	VO[] infoUser = new VO[1];
	String UserId = "";
	String Category = "";
	String RestName = "";
	static int OrderNum;
	int choice = 0;
	int Total = 0;

	Random rd = new Random();
	int tip = rd.nextInt(20) * 100 + 2000;

	// 시작 지점
	public void totalRun() {
		// 첫번째 페이지
		view.open();
		System.out.println("이용시작하기(y/n)");
		String yn = sc.next();
		if (yn.equals("y")) {
			// 두번째 페이지
			view.showStart();
		} else {
			System.out.println("정말 그냥 가시는 건가요...?");
			view.open();
		}

		int choice = sc.nextInt();

		switch (choice) {

		case 1: // 1.로그인 시작
			login();
			break;
		case 2: // 2.회원가입 시작
			join();
			break;
		case 3: // 3. 관리자 페이지 시작
			managerCheck();
			break;
		case 4: // 5. 종료하기
			System.out.println("프로그램이 종료되었습니다.");
			break;
		default:
			System.out.println("다섯 숫자 중 하나를 다시 입력해주세요.");
			totalRun();
			break;
		}

	}

	// 1. 로그인 (예인)
	public void login() {
		view.login();
		LoginDAO dao = new LoginDAO();
		List list = dao.listMembers1(); // 로그인메소드

		System.out.print("아이디를입력하세요 ");
		String USER_ID = sc.next(); // 아이디 입력. 전역변수 userid에 저장
		System.out.print("비밀번호를 입력하세요 ");
		String USER_PW = sc.next(); // 아이디나 비밀번호

		for (int i = 0; i < list.size(); i++) { // 모든 데이터에서 있는지 비교
			LoginVO loginvo = (LoginVO) list.get(i);

			if (loginvo.getUserId().equals(USER_ID) && loginvo.getUserPw().equals(USER_PW)) { // 같은거 하나 찾기!
				UserId = USER_ID; // id전역변수에 로그인 성공한 id를 넣는것
				System.out.println("로그인되었습니다!");

				// 4.카테고리선택, 식당정보선택, 주문선택 시작
				categoryRun(); // 로그인이 된 경우, 은지언니가 만든 메인페이지 가는 걸로 연결하기!!
			}

		}

		if (UserId.equals("")) {
			System.out.println("가입되지 않은 아이디입니다.");
			System.out.println("회원가입 하시겠습니까? y / n "); // ★로그인이 안된 경우 회원가입으로 넘어가기
			String yn = sc.next();
			if (yn.equals("y")) {
				join();
			} else {
				View view = new View();
				view.showStart();
			}
		}
	}

	// 2. 마이페이지(예인)
	public void mypage() {
		LoginDAO dao = new LoginDAO();
		List list = dao.listMember(UserId); // 매개변수로 연결
		List Orders = dao.listOrders(UserId);

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("                                          ");
		System.out.println("------------------------------------------");
		System.out.println("                  내  정보                                           ");
		System.out.println("------------------------------------------");

		for (int i = 0; i < list.size(); i++) {
			LoginVO loginvo = (LoginVO) list.get(i); // 멤버 정보 //데이터베이스화 한 내용을 에 전달, 그 안에 잇는 내용 출력됨
			System.out.println("아이디는 " + loginvo.getUserId() + " 입니다");
			System.out.println("이름은 " + loginvo.getUserName() + " 입니다");
			System.out.println("전화번호는 " + loginvo.getUserPhoneNum() + " 입니다");
			System.out.println("주소는 " + loginvo.getUserAd() + " 입니다");
		}
		System.out.println("                                                     ");
		System.out.println("------------------------------------------");
		System.out.println("                   지난 주문 내역                          ");
		System.out.println("------------------------------------------");

		if (Orders.isEmpty()) {
			System.out.println("아직 주문한 내역이 없습니다");
		} else {
			for (int i = 0; i < Orders.size(); i++) {
				LoginVO loginvo = (LoginVO) Orders.get(i); // 주문내역

				System.out.println("--------------------" + i + "번 주문 입니다-------------");
				System.out.println("      주문건의 번호 " + loginvo.getOrder_Num() + " 입니다           ");
				System.out.println("         아이디는 " + loginvo.getUserId() + " 입니다                  ");
				System.out.println("      음식번호는 " + loginvo.getOrder_Foodnum() + " 입니다      ");
				System.out.println("       음식이름은 " + loginvo.getOrder_Food() + "입니다            ");
				System.out.println("     총 금액은" + loginvo.getOrder_TotalAmount() + "입니다    ");
			}
		}
		System.out.println("카테고리 화면으로 돌아가시겠습니까?(y/n)");
		String yn = sc.next();
		if (yn.equals("y"))
			categoryRun();
	}

	// 3. 회원가입(현아)
	public void join() {
//		view.join();
		JoinDAO dao = new JoinDAO();
		Scanner sc = view.inputKeyboard();

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("");
		System.out.println("  ﾟ+o｡◈｡o+ﾟ+o｡◈｡o+  회원가입    +o｡◈｡o+ﾟ+o｡◈｡o+  ");
		System.out.println("");

		// 1.ID
		// = ""을 써야 null값이 안들어간다!!
		String userId = "";
		boolean loop = true;
		while (loop) {
			System.out.println("   1.ID :"); // DAO에서 중복검사
			userId = sc.next();
			for (int i = 0; i < userId.length(); i++) {
				if (Character.isLetter(userId.charAt(i)) || ('0' <= userId.charAt(i) && userId.charAt(i) <= '9')) {
					loop = false;
				} else {
					System.out.println("ID에 특수문자와 공란은 입력할 수 없습니다.");
					loop = true;
					break;
				}
			}
		}

		System.out.println("");

		// 2.PW
		String userPw = "";
		while (true) {
			String pattern = "^[0-9]*$";
			System.out.println("   2.PASSWORD :");
			userPw = sc.next();
			if (userPw.matches(pattern) && userPw.length() <= 10) {
				break;
			} else {
				System.out.println("숫자만 입력 가능하고 10글자 이하로만 입력가능합니다.");
				continue;
			}
		}
		System.out.println("");

		// 3.name
		String userName = "";
		while (true) {
			String pattern = "^[가-힣]*$";
			System.out.println("   3.이름 :"); // 한글
			userName = sc.next();
			if (userName.matches(pattern) && userName != "") {
				break;
			} else {
				System.out.println("이름에 특수문자, 영어, 공란은 입력할 수 없습니다.");
				continue;
			}
		}
		System.out.println("");

		// 4.identification
		String identification = "";
		boolean boo = true;
		do {
			System.out.println("   4.주민번호 :"); // 13글자 형태
			identification = sc.next();
			if (identification.length() == 14) {
				if (identification.charAt(6) == '-') {
					boolean check = true;
					for (int i = 0; i < 14; i++) {
						if (i != 6) {
							char ch = identification.charAt(i);
							if (ch < '0' || ch > '9') {
								check = false;
							}
						}
					}
					if (check) {
						boo = false;
					} else {
					}
				} else {
					System.out.println("주민번호형식은 123456-1234567입니다");
				}
			} else {
				System.out.println("주민번호형식은 123456-1234567입니다");
			}
		} while (boo);// 주민번호 형식판단

		System.out.println("");

		// 5.userPhoneNum
		String userPhoneNum = "";
		while (true) {
			String pattern = "^[0-9]*$";
			System.out.println("   5.전화번호 :"); // 글자수
			userPhoneNum = sc.next();
			if (userPhoneNum.matches(pattern) && userPhoneNum.length() == 11) {
				break;
			} else {
				System.out.println("전화번호는 11글자 입니다!");
				continue;
			}
		}
		System.out.println("");

		// 6.주소
		System.out.print("6.주소 : ");
		String userAd = "";
		sc.nextLine();
		userAd = sc.nextLine();

		System.out.println("");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓▓█▓█▓█▓");

		// 값을 다 입력 받은 후 DAO에 값을 넘겨준다.
		dao.addMember(userId, userPw, userName, identification, userPhoneNum, userAd);

		System.out.println("회원가입이 완료되었습니다.!");
		System.out.println("로그인 페이지로 넘어갑니다!");
		login();
	}

	// 4.식당,메뉴,장바구니,결제(은지)
	HashMap<Integer, Integer> sameFood = new HashMap<Integer, Integer>();
	// 앞의 Integer에는 basket의 인덱스넘버, 뒤에 Integer에는 추가된 갯수
	ArrayList<VO> basket = new ArrayList<VO>();

	VO[] restList(String Category, VO[] infoCate) {
		List list = dao.restList(Category);
		for (int i = 0; i < list.size(); i++) {
			infoCate[i] = (VO) list.get(i);
		}
		return infoCate;
	}// category를통한 식당 정보 불러오기

	VO[] restInfo(String RestName, VO[] infoRest) {
		List list = dao.restInfo(RestName);
		for (int i = 0; i < list.size(); i++) {
			infoRest[i] = (VO) list.get(i);

		}
		return infoRest;
	}// restInfo를 통한 해당 식당의 총 정보 불러오기

	VO[] logUserInfo(String UserId, VO[] infoUser) {
		List list = dao.logUserInfo(UserId);
		for (int i = 0; i < list.size(); i++) {
			infoUser[i] = (VO) list.get(i);

		}
		return infoUser;
	}// restInfo를 통한 해당 식당의 총 정보 불러오기

	void categoryRun() {
		// 카테고리 화면 출력
		Random rd = new Random();
		int num = rd.nextInt(5);
		View.foodCategories(num);

		int choice = VO.getSetMenu();
		switch (choice) {
		case 1:
			Category = "한식";
			break;
		case 2:
			Category = "중식";
			break;
		case 3:
			Category = "일식";
			break;
		case 4:
			Category = "일품";
			break;
		case 5:
			mypage();
			break;
		default:
			System.out.println("잘못 선택하셨습니다.");
			categoryRun();
			break;

		}

		 if(Category.equals("")) {
	         System.out.println("아무것도 입력되지 않았습니다.");   
	      }else {
	         restInfoRun();
	      }
		 
	} // 식당 카테고리 선정 -> 식당 리스트로 들어가기

	void restInfoRun() {

		infoCate = restList(Category, infoCate);
		View.restaurantsList(infoCate);

		int choice = VO.getSetMenu();

		switch (choice) {
		case 0:
			categoryRun();
			restInfoRun();
			break;
		case 1:
			RestName = infoCate[choice - 1].getRestName();
			break;
		case 2:
			RestName = infoCate[choice - 1].getRestName();
			break;
		case 3:
			RestName = infoCate[choice - 1].getRestName();
			break;
		case 4:
			RestName = infoCate[choice - 1].getRestName();
			break;
		default:
			System.out.println("잘못 선택하셨습니다.");
		}

		orderRun();
	}// 식당 리스트에서 식당 메뉴로 넘어가기

	void orderRun() {
//		int MinPrice = infoRest[0].getMinPrice();
		infoRest = restInfo(RestName, infoRest);
		View.restaurantMenu(infoRest);
		Total = 0;
		int cnt = 0;
		basket.clear();
		sameFood.clear();
		// 메뉴선택 시작
		System.out.println("주문하실 메뉴를 선택해주세요 ☞");
		while (true) {
			choice = VO.getOrder();
			int same = 1;
			int key = 0;

			if (choice == 0) {

				System.out.println("다른 식당보기로 이동하시면 장바구니가 초기화 됩니다 ");
				restInfoRun();
				orderRun();
			}

			if (choice == 11) // 장바구니로 넘어가기
				break;

			if (cnt == 0) {
				basket.add(infoRest[choice - 1]);
				sameFood.put(0, 1);
			} else {
				for (int i = 0; i < basket.size(); i++) { // 선택된 메뉴 중복인지 검사
					if (basket.contains(infoRest[choice - 1])) {
						if (infoRest[choice - 1].getFoodName().equals(basket.get(i).getFoodName())) {
//							System.out.println("i : "+ i);
//							System.out.println("전에시킨 갯수 : " + sameFood.get(i));
							same += sameFood.get(i);
							sameFood.put(i, same);
							System.out.println("총 시킨  갯수 : " + sameFood.get(i));
							key = i;
							break;
						}
					} else { // 중복이 아니라면 추가
						basket.add(infoRest[choice - 1]);
						sameFood.put(basket.size() - 1, same);
						System.out.println("새로추가된 메뉴 시킨갯수 : " + sameFood.get(basket.size() - 1));
						key = basket.size() - 1;
						break;
					}
				}
			} // 중복검사 끝

			Total += infoRest[choice - 1].getUnitPrice();
			System.out.println(infoRest[choice - 1].getFoodName() + " " + sameFood.get(key) + "개가 장바구니에 추가됐습니다.");
			System.out.println("총 금액 : " + Total);
			System.out.println("-------------------------------------------");
			cnt++; // 총 몇개시키는지 셈
			if (Total < infoRest[choice - 1].getMinPrice()) { // 주문금액이 주문최소금액보다 작으면 더골르라는 팝업
				View.orderPopUp();
			} else { // 최소금액보다 많이 나오면 결제하겠냐고 물어보기
				System.out.println("장바구니로가려면 11번을 눌러주세요☞");
				System.out.println();
				System.out.println("계속 고르려면 추가 할 메뉴번호를 눌러주세요 ☞");
				System.out.println("-------------------------------------------");
			}

		}

		myBasket();
	}// 결제창

	void myBasket() {
		// 장바구니창 시작
		View.orderList(basket, sameFood, Total, tip);
		infoUser = logUserInfo(UserId, infoUser);
		System.out.println("주문하시려면 1번을 눌러주세요☞ ");
		choice = VO.getOrder();
		if (choice == 0) {
			orderRun();
			myBasket();
		}

		payment();
	}

	void payment() {
		// 결제창 시작
		if (choice == 1)
			View.payment(infoUser, Total, tip); // 결제창 출력

		String pay[] = { "현금/카드 ", "휴대폰 결제", "까까오페이" };
		System.out.println("결제 방식을 입력해주세요 ☞ ");

		boolean boo = true;
		while (boo) {
			choice = VO.getOrder();
			switch (choice) {
			case 0:
				myBasket();
				payment();
				break;
			case 1:
				System.out.println(pay[choice - 1] + " 결제를 선택하셨습니다");
				break;
			case 2:
				System.out.println(pay[choice - 1] + " 결제를 선택하셨습니다");
				break;
			case 3:
				System.out.println(pay[choice - 1] + " 결제를 선택하셨습니다");
				break;
			default:
				System.out.println("결제방식을 다시 선택해주세요");
			}
			break;
		}

		paySuccess();
	}

	void paySuccess() {

		System.out.println("결제하시려면 4번을 눌러주세요");
		choice = VO.getOrder();
		switch (choice) {
		case 0:
			myBasket();
			payment();
		case 4:
			View.payment2(); // 결제를 시작합니다 출력
			System.out.println();
			View.payment3(); // 결제중입니다 출력
			// 주문 데이터 DB로 넘기기
			Total += tip;
			int RestRegiNum = basket.get(0).getRestRegiNum();
			OrderNum = dao.lastOrderNum() + 1;
			dao.addOrder(OrderNum, UserId, RestRegiNum, Total);
			dao.addOrderDetail(basket, OrderNum);
			System.out.println("결제완료");
			break;
		}

		end();
	}

	void end() {

		// 배달소요시간
		Random rd = new Random();
		int time = rd.nextInt(31) + 30;
		View.end(time, basket, OrderNum);

		System.out.println("시작화면으로 돌아가시겠습니까?(y/n)");
		String yn = sc.next();
		if (yn.equals("y")) {
			totalRun();
		} else {
			System.out.println("이용해주셔서 감사합니다!");
		}
	}

	// 5.관리자 아이디 비번 체크(상우시작)
	public void managerCheck() {
		ManagerDAO dao = new ManagerDAO();
		List list = dao.managerCheck();
		String idCheck = "";
		System.out.println("관리자 ID:");
		String id = sc.next();
		System.out.println("관리자 PW:");
		String pw = sc.next();

		for (int i = 0; i < list.size(); i++) {
			ManagerVO membervo = (ManagerVO) list.get(i);
			if (membervo.getUserId().equals(id) && membervo.getUserPw().equals(pw)) {
				idCheck = id;
				System.out.println("관리자로 로그인되었습니다.");
				managerStart();
			}
		}
		if (idCheck.equals("")) {
			System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
			System.out.println("뒤로가시겠습니까?(y/n)");
			String yn = sc.next();
			if (yn.equals("y")) {
				managerStart();
			} else {
				managerCheck();
			}
		}

	}

	// 5-1.관리자창 시작
	public void managerStart() {
		view.manager();
		int choice = sc.nextInt();
		view.choiceManage(choice);

	}

	// 5-2.모든회원 조회 or 한명의 결제정보
	public void usersInfo() {
		ManagerDAO dao = new ManagerDAO();
		List list = dao.listMember();
		String name = "";

		System.out.print("모든회원 or 특정회원> ");
		String Allone = sc.next(); // 아이디나 비밀번호
		if (Allone.equals("모든회원")) {
			for (int i = 0; i < list.size(); i++) {
				ManagerVO membervo = (ManagerVO) list.get(i);
				System.out.println("--------------------[" + (i + 1) + "]-------------------");
				System.out.println("회원 이름: " + membervo.getUserName());
				System.out.println("회원 아이디:" + membervo.getUserId());
				System.out.println("회원 비밀번호: " + membervo.getUserPw());
				System.out.println("회원 주민번호: " + membervo.getUserIdentication());
				System.out.println("회원 전화번호: " + membervo.getUserPhoneNum());
				System.out.println("회원 주소: " + membervo.getUserAd());
				System.out.println("------------------------------------------");

			}
			System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓");
			System.out.println("1.뒤로가기  2.다시검색하기");
			int choice = sc.nextInt();
			if (choice == 1) {
				managerStart();
			} else {
				usersInfo();
			}
		}

		if (Allone.equals("특정회원")) {
			System.out.println("어떤 회원을 조회하시겠습니까? "); // 아이디 비번
			String inputName = sc.next();

			for (int i = 0; i < list.size(); i++) {
				ManagerVO membervo = (ManagerVO) list.get(i);
				if (membervo.getUserName().equals(inputName)) {
					System.out.println("==================회원<" + (i + 1) + ">==================");
					System.out.println("회원 이름: " + membervo.getUserName());
					System.out.println("회원 아이디:" + membervo.getUserId());
					System.out.println("회원 비밀번호: " + membervo.getUserPw());
					System.out.println("회원 주민번호: " + membervo.getUserIdentication());
					System.out.println("회원 전화번호: " + membervo.getUserPhoneNum());
					System.out.println("회원 주소: " + membervo.getUserAd());
					name = inputName;
				}
			}

			List orderslist = dao.listOrders(name);
			for (int i = 0; i < orderslist.size(); i++) {
				ManagerVO ordersvo = (ManagerVO) orderslist.get(i);
				System.out.println("-----------------주문 정보<" + (i + 1) + ">----------------");
				System.out.println("주문 번호: " + ordersvo.getORDER_NUM());
				System.out.println("주문 식당 사업자등록번호: " + ordersvo.getREST_REGINUM());
				System.out.println("주문 식당이름: " + ordersvo.getREST_NAME());
				System.out.println("주문 음식이름: " + ordersvo.getORDER_FOOD());
				System.out.println("주문 총 금액: " + ordersvo.getORDER_TOTALAMOUNT());
				System.out.println("------------------------------------------");
			}
			System.out.println("==========================================");
			System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");

			if (name.equals("")) {
				System.out.println("등록된 회원이 아닙니다.");
			}

			System.out.println("1.뒤로가기  2.다시검색하기");
			int choice = sc.nextInt();
			if (choice == 1) {
				managerStart();
			} else {
				usersInfo();
			}

		}
	}

	// 5-3.회원정보 수정
	public void updateOneUser() {
		System.out.print("정보를 수정할 아이디 입력: ");
		String id = sc.nextLine();
		ManagerDAO dao = new ManagerDAO();

		List list = dao.listMember();
		for (int i = 0; i < list.size(); i++) {
			ManagerVO membervo = (ManagerVO) list.get(i);
			if (membervo.getUserId().equals(id)) {
				System.out.print("회원이름: ");
				String UserName = sc.next();
				System.out.print("회원비밀번호: ");
				String UserPw = sc.next();
				System.out.print("회원 전화번호: ");
				String UserPhoneNum = sc.next();
				System.out.print("회원 주민번호: ");
				String UserIdentication = sc.next();
				System.out.print("회원 주소: ");
				sc.nextLine();
				String UserAdd = sc.nextLine();

				ManagerVO vo = new ManagerVO();
				vo.setUserName(UserName);
				vo.setUserId(id);
				vo.setUserPw(UserPw);
				vo.setUserPhoneNum(UserPhoneNum);
				vo.setUserIdentication(UserIdentication);
				vo.setUserAd(UserAdd);
				dao.updateMember(vo);
			}
		}

		System.out.println("1.뒤로가기  2.다시수정하기");
		int choice = sc.nextInt();
		if (choice == 1) {
			managerStart();
		} else {
			updateOneUser();
		}

	}

	// 5-4. 회원별 누적 구매액 순위 조회(많은 순)
	public void userAmountRank() {
		ManagerDAO dao = new ManagerDAO();
		List list = dao.listUserAmountRank();

		System.out.println("            회원 아이디        |     누적 주문액               ");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			ManagerVO ordersvo = (ManagerVO) list.get(i);
			System.out.println("        " + ordersvo.getSUM_RANK() + "위: " + ordersvo.getUSER_ID() + " | "
					+ ordersvo.getSUM_TOTALAMOUNT() + "원 ");
		}
		System.out.println("-------------------------------------------");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓");
		System.out.println("뒤로가시겠습니까?(y/n)");
		String yn = sc.next();
		if (yn.equals("y")) {
			managerStart();
		} else {
			userAmountRank();
		}
	}

	// 5-5.식당별 누적 주문 금액 순위 조회
	public void restAmountRank() {
		ManagerDAO dao = new ManagerDAO();
		List list = dao.listRestAmount();

		System.out.println("     순위 | 사업자등록번호 | 식당이름 | 누적 주문 금액          ");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			ManagerVO ordersvo = (ManagerVO) list.get(i);
			System.out.println("  " + ordersvo.getSUM_RANK() + "위| " + ordersvo.getREST_REGINUM() + " | "
					+ ordersvo.getREST_NAME() + " | " + ordersvo.getSUM_TOTALAMOUNT() + "원");
		}
		System.out.println("-------------------------------------------");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓");
		System.out.println("뒤로가시겠습니까?(y/n)");
		String yn = sc.next();
		if (yn.equals("y")) {
			managerStart();
		} else {
			restAmountRank();
		}

	}

	// 5-6. 음식별 주문건수 순위 조회(많은순)
	public void FoodCountRank() {
		ManagerDAO dao = new ManagerDAO();
		List list = dao.FoodCountRank();

		System.out.println(" 순위 | 사업자등록번호 | 식당이름 | 주문된 음식 | 누적 주문건  ");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			ManagerVO ordersvo = (ManagerVO) list.get(i);
			System.out.println(" " + ordersvo.getCOUNT_RANK() + "위 |   " + ordersvo.getREST_REGINUM() + "   | "
					+ ordersvo.getREST_NAME() + " | " + ordersvo.getORDER_FOOD() + " | " + ordersvo.getCOUNT_FOOD()
					+ "건      ");
		}
		System.out.println("-------------------------------------------");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓");
		System.out.println("뒤로가시겠습니까?(y/n)");
		String yn = sc.next();
		if (yn.equals("y")) {
			managerStart();
		} else {
			FoodCountRank();
		}

	}

	// 5-7. 음식별 주문금액 순위 조회
	public void FoodAmountRank() {
		ManagerDAO dao = new ManagerDAO();
		List list = dao.FoodAmountRank();

		// 수정하기
		System.out.println(" 순위 | 사업자등록번호 | 식당이름   | 주문된 음식 | 누적 주문액 ");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			ManagerVO ordersvo = (ManagerVO) list.get(i);
			System.out.println(" " + ordersvo.getSUM_RANK() + "위 |   " + ordersvo.getREST_REGINUM() + "   | "
					+ ordersvo.getREST_NAME() + " | " + ordersvo.getORDER_FOOD() + " | " + ordersvo.getSUM_TOTALAMOUNT()
					+ "원 ");
		}
		System.out.println("-------------------------------------------");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓");
		System.out.println("뒤로가시겠습니까?(y/n)");
		String yn = sc.next();
		if (yn.equals("y")) {
			managerStart();
		} else {
			FoodAmountRank();
		}

	}

	// 5-8.맛집추천
	public void recommendFood() {
		ManagerDAO dao = new ManagerDAO();
		List list = dao.recommendFood();

		for (int i = 0; i < 3; i++) {
			ManagerVO ordersvo = (ManagerVO) list.get(i);
			System.out.println("<인기 음식 추천!!> " + ordersvo.getREST_NAME() + "의 " + ordersvo.getORDER_FOOD());
		}
	}

}
