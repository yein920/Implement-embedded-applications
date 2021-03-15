package Team_project2_fin;

public class ManagerVO {
	//유저테이블의 정보
	String UserId;
	String UserPw;
	String UserName;
	String UserIdentication;
	String UserPhoneNum;
	String UserAd;
	
	//모든 주문테이블의 정보
	int ORDER_NUM;
	String USER_ID;
	int REST_REGINUM;
	int ORDER_FOODNUM;
	String ORDER_FOOD;
	String ORDER_NAME;
	int ORDER_TOTALAMOUNT;
	
	//식당, 음식별 누적 주문건수,주문액, 랭킹에 대한 부분
	int SUM_TOTALAMOUNT;
	int COUNT_FOOD;
	int COUNT_RANK;
	int SUM_RANK;
	
	//식당정보
	String REST_NAME;
	
	//음식메뉴정보
	int FOOD_NUM;


	
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
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserIdentication() {
		return UserIdentication;
	}
	public void setUserIdentication(String userIdentication) {
		UserIdentication = userIdentication;
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
	
	public int getORDER_NUM() {
		return ORDER_NUM;
	}
	public void setORDER_NUM(int oRDER_NUM) {
		ORDER_NUM = oRDER_NUM;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public int getREST_REGINUM() {
		return REST_REGINUM;
	}
	public void setREST_REGINUM(int rEST_REGINUM) {
		REST_REGINUM = rEST_REGINUM;
	}
	public int getORDER_FOODNUM() {
		return ORDER_FOODNUM;
	}
	public void setORDER_FOODNUM(int oRDER_FOODNUM) {
		ORDER_FOODNUM = oRDER_FOODNUM;
	}
	public String getORDER_FOOD() {
		return ORDER_FOOD;
	}
	public void setORDER_FOOD(String oRDER_FOOD) {
		ORDER_FOOD = oRDER_FOOD;
	}
	public String getORDER_NAME() {
		return ORDER_NAME;
	}
	public void setORDER_NAME(String oRDER_NAME) {
		ORDER_NAME = oRDER_NAME;
	}
	public int getORDER_TOTALAMOUNT() {
		return ORDER_TOTALAMOUNT;
	}
	public void setORDER_TOTALAMOUNT(int oRDER_TOTALAMOUNT) {
		ORDER_TOTALAMOUNT = oRDER_TOTALAMOUNT;
	}

	public int getSUM_TOTALAMOUNT() {
		return SUM_TOTALAMOUNT;
	}
	public void setSUM_TOTALAMOUNT(int sUM_TOTALAMOUNT) {
		SUM_TOTALAMOUNT = sUM_TOTALAMOUNT;
	}
	public int getCOUNT_FOOD() {
		return COUNT_FOOD;
	}
	public void setCOUNT_FOOD(int cOUNT_FOOD) {
		COUNT_FOOD = cOUNT_FOOD;
	}
	public int getCOUNT_RANK() {
		return COUNT_RANK;
	}
	public void setCOUNT_RANK(int cOUNT_RANK) {
		COUNT_RANK = cOUNT_RANK;
	}
	public int getSUM_RANK() {
		return SUM_RANK;
	}
	public void setSUM_RANK(int sUM_RANK) {
		SUM_RANK = sUM_RANK;
	}
	
	public String getREST_NAME() {
		return REST_NAME;
	}
	public void setREST_NAME(String rEST_NAME) {
		REST_NAME = rEST_NAME;
	}
	public int getFOOD_NUM() {
		return FOOD_NUM;
	}
	public void setFOOD_NUM(int fOOD_NUM) {
		FOOD_NUM = fOOD_NUM;
	}
}
