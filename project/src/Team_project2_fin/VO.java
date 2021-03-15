package Team_project2_fin;

import java.util.Scanner;

public class VO {
	private static Scanner sc = new Scanner(System.in);
	
	String RestName;
	String Category;
	String RestAddress;
	String FoodName;
	String Phone;
	String UserPhoneNum;
	String UserAddress;
	String UserId;
	int RestRegiNum;
	int OrderNum;
	int MinPrice;
	int FoodNum;
	int UnitPrice;


	//사용자의 정보 
	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	} //로그인한 사용자 ID	
	
	public String getUserPhoneNum() {
		return UserPhoneNum;
	}

	public void setUserPhoneNum(String userPhoneNum) {
		UserPhoneNum = userPhoneNum;
	}//로그인한 사용자의 핸드폰번호

	public String getUserAddress() {
		return UserAddress;
	}

	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}//로그인한 사용자의 주소 
	
	
	
	//카테고리부터 장바구니, 결제
	
	public static Scanner inputKeyboard() {
		return sc;
	}
		
	public static int getSetMenu() {
		System.out.println("번호를 선택해주세요 ☞");	
		return sc.nextInt();
	}//번호선택메소드
	
	public static int getOrder() {
		return sc.nextInt();
	}//입력받는 메소드
	
	public static String getAnswer() {
		return sc.nextLine();
	}

	public String getRestName() {
		return RestName;
	}
	public void setRestName(String restName) {
		RestName = restName;
	}//식당이름 
	
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}//식당 카테고리
	
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}//식당 전화 번호
	
	public int getRestRegiNum() {
		return RestRegiNum;
	}

	public void setRestRegiNum(int restRegiNum) {
		RestRegiNum = restRegiNum;
	}//식당 등록번호 
	
	
	public String getRestAddress() {
		return RestAddress;
	}
	public void setRestAddress(String address) {
		RestAddress = address;
	}//식당 주소
	
	
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodMenu) {
		FoodName = foodMenu;
	}//식당 메뉴	
	
	
	public int getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		UnitPrice = unitPrice;
	}//메뉴 단가 
	
		
	public int getMinPrice() {
		return MinPrice;
	}
	public void setMinPrice(int miniPrice) {
		MinPrice = miniPrice;
	}//최소 주문금액
	
	public int getFoodNum() {
		return FoodNum;
	}

	public void setFoodNum(int foodNum) {
		FoodNum = foodNum;
	}//주문시킨 음식별 갯수 
	
	public int getOrderNum() {
		return OrderNum;
	}

	public void setOrderNum(int orderNum) {
		OrderNum = orderNum;
	}//주문번호 


}
