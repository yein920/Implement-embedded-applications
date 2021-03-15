package Team_project2_fin;

public class LoginVO { 
	// users 테이블 정보 
	String UserId;
	String UserPw;
	String UserName;
	String UserPhoneNum;
	String UserAd;
	
	// order 테이블 정보
	int Order_Num;
	int Order_Foodnum;
	String Order_Food;
	int Order_Date;
	String Category;
	int Order_TotalAmount;
	int food_num;
	int rest_reginum;

	
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPhoneNum() {
		return UserPhoneNum;
	}

	public void setUserPhoneNum(String userPhoneNum) {
		UserPhoneNum = userPhoneNum;
	}

	public String getUserAd() {
		return UserAd;
	}

	public void setUserAd(String userAd) {
		UserAd = userAd;
	}

	public void setRest_reginum(int rest_reginum) {
		this.rest_reginum = rest_reginum;
	}

	public int getRest_reginum() {
		return rest_reginum;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserPw() {
		return UserPw;
	}

	public void setUserPw(String userPw) {
		UserPw = userPw;

	}

	public void setOrder_Num(int order_Num) {
		Order_Num = order_Num;
	}

	public void setOrder_Foodnum(int order_Foodnum) {
		Order_Foodnum = order_Foodnum;
	}

	public void setOrder_Food(String order_Food) {
		Order_Food = order_Food;
	}

	public void setOrder_Date(int order_Date) {
		Order_Date = order_Date;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public void setOrder_TotalAmount(int order_TotalAmount) {
		Order_TotalAmount = order_TotalAmount;
	}

	public void setFood_num(int food_num) {
		this.food_num = food_num;
	}

	public int getOrder_Num() {
		return Order_Num;
	}

	public int getOrder_Foodnum() {
		return Order_Foodnum;
	}

	public String getOrder_Food() {
		return Order_Food;
	}

	public int getOrder_Date() {
		return Order_Date;
	}

	public String getCategory() {
		return Category;
	}

	public int getOrder_TotalAmount() {
		return Order_TotalAmount;
	}

	public int getFood_num() {
		return food_num;
	}

}
