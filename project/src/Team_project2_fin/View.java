package Team_project2_fin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class View {
	private Scanner sc = new Scanner(System.in);
	static Controller con = new Controller();
	
	public Scanner inputKeyboard() {
		return sc;
	}

	public void open() {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("                                          ");
		System.out.println("                                          ");
		System.out.println("\t.:+・✽비대면결제를 위한 배달앱✽・+:.		  ");
		System.out.println("                                          ");
		System.out.println("                                          ");
		System.out.println("\t\t저   기   요                                   ");
		System.out.println("                                          ");
		System.out.println("                                          ");
		System.out.println("                                          ");
		System.out.println("                                          ");
		System.out.println("                                          ");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
	}

	public void showStart() {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("");
		System.out.println("");
		System.out.println("               1. LOGIN                   ");
		System.out.println("");
		System.out.println("           \"혹시 저기요가 처음이신가요?\"");
		System.out.println("");
		System.out.println("               2. 회원가입 ");
		System.out.println("");
		System.out.println("               3. 관리자 페이지");
		System.out.println("");
		System.out.println("               4. 종료하기");
		System.out.println("");
		System.out.println("");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");

	}

	public void login() {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("                                          ");
		System.out.println("  ﾟ+o｡◈｡o+ﾟ+o｡◈｡o+  LOGIN  +o｡◈｡o+ﾟ+o｡◈｡o+   ");
		System.out.println("");
		System.out.println("            1. ID :                       ");
		System.out.println("");
		System.out.println("            2. PASSWORD :                 ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
	}

	public void join() {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("");
		System.out.println("  ﾟ+o｡◈｡o+ﾟ+o｡◈｡o+  회원가입    +o｡◈｡o+ﾟ+o｡◈｡o+  ");
		System.out.println("");
		System.out.println("   1.ID :");
		System.out.println("");
		System.out.println("   2.PASSWORD :");
		System.out.println("");
		System.out.println("   3.이름 :");
		System.out.println("");
		System.out.println("   4.주민번호 :");
		System.out.println("");
		System.out.println("   5.전화번호 :");
		System.out.println("");
		System.out.println("   6.주소 :");
		System.out.println("");
		System.out.println("");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
	}

	public static void foodCategories(int num) {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("                                          ");
		System.out.println("-------------------------------------------");
		switch (num) {
		case 0:
			System.out.println(" {\\___/} 🍗   🍗   🍗   🍗  🍗   🍗  🍗   🍗  🍗   🍗  🍗  "); // 광고는 가능 하다면 !
			System.out.println(" ( •   ▽ •)          '비트 치킨'               ");
			System.out.println(" /つ 🍗                  월요일은 허니 콤보 먹는 날                    "); // 그냥 랜덤돌려서 몇개 넣으면 될거같음
			break;
		case 1:
			System.out.println("  @▷□◁ @  🍰   🍰   🍰   🍰   🍰   🍰   🍰   🍰   🍰   🍰 "); // 광고는 가능 하다면 !
			System.out.println(" (๑◕‿‿◕๑)   	 '달콤한 디저트 데이'");
			System.out.println(" /  つ  🍰                  화요일은 달콤한 케이크 어떠세요?"); // 그냥 랜덤돌려서 몇개 넣으면 될거같음
			break;
		case 2:
			System.out.println(" 💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻"); // 광고는 가능 하다면 !
			System.out.println("( ༼ ◉ _◉༽  )수요일은 코딩하는날 비트컴퓨터로 코딩하러오세요");
			System.out.println("/つ 🍺 💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻"); // 그냥 랜덤돌려서 몇개 넣으면 될거같음
			break;
		case 3:
			System.out.println(" ♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡"); // 광고는 가능 하다면 !
			System.out.println("(๑•̀ㅁ•́๑)✧ 목요일에는 비트 떡볶이 먹는날!!!!!!!!!!!");
			System.out.println("/つ   🥘    ♥♡ ♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡"); // 그냥 랜덤돌려서 몇개 넣으면 될거같음
			break;
		case 4:
			System.out.println(" ♨♨♨★★★★★★★★★★★★★★★★★★★★★★★★★★★★"); // 광고는 가능 하다면 !
			System.out.println("( ✪ ‿ ✪  )★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("/つ 🍺 금요일밤에는 치킨엔 맥주!★★★★★★★★★★★★★★★★"); // 그냥 랜덤돌려서 몇개 넣으면 될거같음
			break;
		}
		System.out.println("-------------------------------------------");
		System.out.println("✽+†+✽――✽+†+✽――✽+†+✽―✽+†+✽――✽+†+✽――✽+†+✽");
	
		con.recommendFood();
		System.out.println("✽+†+✽――✽+†+✽――✽+†+✽―✽+†+✽――✽+†+✽――✽+†+✽");
		System.out.println("-------------------------------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("        1. 한식                         2. 중식                        ");
		System.out.println("");
		System.out.println("        3. 일식                         4. 일품                         ");
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("                 5.마이페이지  가기                               ");
		System.out.println("                 0.뒤로가기                                        ");
		System.out.println("-------------------------------------------");
		System.out.println("");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println();
	}

//	{\__/}
//	( • ▽ •)
//	/つ 🍺 치킨엔 맥주!
//	

	public static void restaurantsList(VO[] infoCate) {
		String emo = null;
		switch (infoCate[0].getCategory()) {
		case "한식":
			emo = "🍚";
			break;
		case "중식":
			emo = "🍲";
			break;
		case "일식":
			emo = "🍣";
			break;
		case "일품":
			emo = "🍗";
			break;
		}

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("-------------------------------------------");
		System.out.println("\t\t      " + infoCate[0].getCategory() + emo + "\t\t   ");
		System.out.println("-------------------------------------------");
		System.out.println();
		for (int i = 0; i < infoCate.length; i++) {
			System.out.print(" " + (i + 1) + ". " + infoCate[i].getRestName() + "\t\t");
			System.out.print("최소 주문금액 : " + infoCate[i].getMinPrice());
			System.out.println();
			System.out.println();
		}
		System.out.println();
		System.out.println("                  0.뒤로가기                                             ");
		System.out.println();
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println();
	} // 간단하게 수정한 category

	public static void restaurantMenu(VO[] infoRest) {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("-------------------------------------------");
		System.out.println("\t\t" + infoRest[0].getRestName() + "\t\t     ");
		System.out.println("-------------------------------------------");
		System.out.println(" 최소 주문금액 : " + infoRest[0].getMinPrice());
		System.out.println(" 주소 : " + infoRest[0].getRestAddress());
		System.out.println(" 전화번호 : " + infoRest[0].getPhone());
		System.out.println("-------------------------------------------");
		System.out.println("                📜   메뉴  📜                                          ");
		System.out.println();
		for (int i = 0; i < infoRest.length; i++) {
			System.out
					.println((i + 1) + ". " + infoRest[i].getFoodName() + "\t\t\t" + infoRest[i].getUnitPrice() + "원");
		}

		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("\t\t 11. 장바구니로 가기  🛍  ");
		System.out.println("\t\t 0. 뒤로가기");
		System.out.println();
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println();
	}

	public static void orderPopUp() {
		System.out.println("------------------------------");
		System.out.println("|                            |");
		System.out.println("| 최소주문 금액이 넘어야 결제가 됩니다  |");
		System.out.println("|      💵  더  추가해주세요 💵              |");
		System.out.println("|                            |");
		System.out.println("------------------------------");
		System.out.println();
	}

	public static void orderList(ArrayList<VO> basket, HashMap<Integer, Integer> sameFood, int Total, int tip) {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("--------------------------------------------");
		System.out.println("\t\t" + basket.get(0).getRestName() + "\t\t\t");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < basket.size(); i++) {
			System.out.println(basket.get(i).getFoodName());
			System.out.println(sameFood.get(i) + " 개");
			System.out.println(basket.get(i).getUnitPrice() * sameFood.get(i));
			System.out.println("--------------------------------------------");
		}

		System.out.println("--------------------------------------------");
		System.out.println(" 주문금액 : " + (Total) + "원");
		System.out.println(" 배달팁    : " + tip + "원 ");
		System.out.println("--------------------------------------------");
		System.out.println("\t" + "1." + (Total + tip) + " 원 주문 하기  🛍  ");
		System.out.println("                0. 뒤로 가기                                    ");  //최소금액이 넘지 않았습니다 문구 추가 
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println();
	} // 장바구니

	public static void payment(VO[] infoUser, int Total, int tip) {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("--------------------------------------------");
		System.out.println("\t\t🏠  배달 정보  🏠 ");
		System.out.println();
		System.out.println("  주소 : " + infoUser[0].getUserAddress());
		System.out.println();
		System.out.println("  연락처 : " + infoUser[0].getUserPhoneNum());
		System.out.println();
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		System.out.println("\t\t💳  결제수단 💳  ");
		System.out.println("  1. 신용 / 체크카드 ");
		System.out.println("  2. 휴대폰결제 ");
		System.out.println("  3. 까까오페이 ");
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		System.out.println("\t\t💰  결제금액  💰 ");
		System.out.println("  주문금액  \t\t\t" + Total + " 원");
		System.out.println("  배달팁    \t\t\t " + tip + "원 ");
		System.out.println("--------------------------------------------");
		System.out.println("             4. " + (Total + tip) + "원 결제하기   🛍  ");
		System.out.println("             0. 뒤로 가기                                          ");
		System.out.println();
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println();
	}

	public static void payment2() {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|              결제를 시작합니다...            |");
		System.out.println("|                                          |");
		System.out.println("|                🤑   💳  🤑                                              |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println();
	}

	public static void payment3() {

		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|              결제가 진행중입니다...           |");
		System.out.println("|                                          |");
		System.out.println("|                🤑   💳  🤑                                              |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println();
	}

	 public static void end(int time, ArrayList<VO> basket, int OrderNum) {

	      System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
	      System.out.println("");
	      System.out.println("\t\t결  제  완  료                   ");
	      System.out.println("");
	      System.out.println("\t\t배달 예상 소요시간  : " + time + " 분               ");
	      System.out.println("");
	      System.out.println("\t\t주문번호 : " + OrderNum);
	      System.out.println("");
	      System.out.println("\t\t식당 : " + basket.get(0).getRestName());
	      for (int j = 0; j < basket.size(); j++) {
	         System.out.println("\t\t메뉴 : " + basket.get(j).getFoodName());
	      }
	      System.out.println("");
	      System.out.println("");
	      System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█");
	      System.out.println();
	   }

	public void manager() {
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
		System.out.println("------------------------------------------");
		System.out.println("                 관리자 모드                                       ");
		System.out.println("------------------------------------------");
		System.out.println(" [1]회원정보 조회                                                                 ");
		System.out.println(" [2]회원정보 수정                                                                 ");
		System.out.println(" [3]회원별 누적 구매액 순위 조회                                               ");
		System.out.println(" [4]식당별 총 주문된 금액 순위 조회                                         ");
		System.out.println(" [5]음식별 누적 주문건수 순위 조회                                          ");
		System.out.println(" [6]음식별 누적 주문금액  순위 조회                                        ");
		System.out.println("------------------------------------------");
		System.out.println("                                          ");
		System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓█▓");

	}

	// 2.관리자 기능 선택
	public void choiceManage(int choice) {
	
		switch (choice) {
		case 1:
			System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
			System.out.println("------------------------------------------");
			System.out.println("                  회원정보 조회                                    ");
			System.out.println("------------------------------------------");
			con.usersInfo();
			break;
		case 2:
			System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
			System.out.println("------------------------------------------");
			System.out.println("                  회원정보 수정                                    ");
			System.out.println("------------------------------------------");
			con.updateOneUser();
			break;
		case 3:
			System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
			System.out.println("-------------------------------------------");
			System.out.println("              회원별 누적 구매액 순위 조회                         ");
			System.out.println("-------------------------------------------");
			con.userAmountRank();

			break;
		case 4:
			System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
			System.out.println("-------------------------------------------");
			System.out.println("             식당별 누적 주문 금액 순위 조회                        ");
			System.out.println("-------------------------------------------");
			con.restAmountRank();

			break;
		case 5:
			System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
			System.out.println("-------------------------------------------");
			System.out.println("             음식별 누적 주문건수 순위 조회                       ");
			System.out.println("-------------------------------------------");
			con.FoodCountRank();

			break;
		case 6:
			System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
			System.out.println("-------------------------------------------");
			System.out.println("            음식별 누적 주문금액  순위 조회                         ");
			System.out.println("-------------------------------------------");
			con.FoodAmountRank();

			break;
		case 7:
			System.out.println("▓█▓█▓█▓█▓█▓█▓█▓█   저  기  요    ▓█▓█▓█▓█▓█▓█▓█▓█");
			System.out.println("-------------------------------------------");
			System.out.println("                   맛집 추천                           ");
			System.out.println("-------------------------------------------");
			con.recommendFood();

			break;
		default:
			break;
		}
	}

}
