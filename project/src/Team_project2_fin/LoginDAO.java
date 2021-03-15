package Team_project2_fin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {// 사우
	// 3. 클래스변수 선언
	Connection con = null; // 오라클 접속에 필요
	PreparedStatement preStmt = null; // SQL문 실행에 필요
	ResultSet rs = null; // 쿼리문 처리 후 결과값 저장에 필요
	int cnt = 0;

	void conn() {
		// 1.오라클 접속에 필요한 클래스를 메모리에 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.url,id,pass 저장
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "bitTest";
		String pass = "bitTest";

		// 4. 오라클 접속
		try {
			con = DriverManager.getConnection(url, id, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 1.로그인
	public List listMembers1() {
		List list = new ArrayList();

		try {
			conn(); // 오라클 연결
			String userSelect = "SELECT * FROM users ";		//쿼리문
			preStmt = con.prepareStatement(userSelect); //오라클에 접속해서 쿼리문 실행해(맨마지막필수)

			rs = preStmt.executeQuery();  //오라클 연결, 명령된 쿼리문의 내용들을 rs에 담으렴

			while (rs.next()) { // 테이블의 행단위로 하나씩 가져옴
				String UserId = rs.getString(1);
				String UserPw = rs.getString(2);

				LoginVO loginvo = new LoginVO();
				loginvo.setUserId(UserId);
				loginvo.setUserPw(UserPw);

				list.add(loginvo);

			}
			rs.close();
			preStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2-1. 마이페이지 회원 정보 조회
	public List listMember(String USER_ID) {	//매개변수로 컨트롤러에 연결
		List list = new ArrayList();

		try {
			conn(); // 오라클 연결
			String userSelect = "SELECT * FROM users where user_id = ?";	//해당되는 id의 전체내역만 가져오겟음 
			preStmt = con.prepareStatement(userSelect);		//쿼리실행해 
			preStmt.setString(1, USER_ID);		//몇번째 물음표냐면~ 첫번째 물음표! 글고 user_id를 가져올거얌 
			rs = preStmt.executeQuery();		//조건들 다 담은 데이터를 rs에 담아랏 

			while (rs.next()) { // // 테이블의 행단위로 하나씩 가져옴
				String UserId = rs.getString(1);
				String UserPw = rs.getString(2);
				String UserName = rs.getString(3);
				String UserPhoneNum = rs.getString(5); //실제 데이터에는 4번째 데이터가 있지만 필요없음! 
				String UserAd = rs.getString(6);		//실제데이터의 몇번째 스트링을 알려줌 

				LoginVO loginvo = new LoginVO();
				loginvo.setUserId(UserId);
				loginvo.setUserPw(UserPw);
				loginvo.setUserName(UserName);
				loginvo.setUserPhoneNum(UserPhoneNum);
				loginvo.setUserAd(UserAd);

				list.add(loginvo);

			}
			rs.close();
			preStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2-1. 마이페이지 주문내역
	public List listOrders(String USER_ID) {

		List list = new ArrayList();
		try {
			conn();
			String userSelect = "SELECT orders.order_num, FOOD_NUM, order_food, user_id, rest_reginum, order_totalamount \r\n"
					+ "FROM ordersdetail, orders\r\n" + "WHERE orders.order_num = ordersdetail.order_num\r\n"
					+ "        and user_id = ? ";
			preStmt = con.prepareStatement(userSelect);
			preStmt.setString(1, USER_ID);
			rs = preStmt.executeQuery();

			while (rs.next()) { //  테이블의 행단위로 하나씩 가져옴
				int Order_Num = rs.getInt(1);
				int Order_Foodnum = rs.getInt(2);
				String Order_Food = rs.getString(3);
				String user_id = rs.getString(4);
				int rest_reginum = rs.getInt(5);
				int Order_TotalAmount = rs.getInt(6);

				LoginVO loginvo = new LoginVO();

				loginvo.setOrder_Num(Order_Num);
				loginvo.setOrder_Foodnum(Order_Foodnum);
				loginvo.setOrder_Food(Order_Food);
				loginvo.setUserId(user_id);
				loginvo.setRest_reginum(rest_reginum);

				loginvo.setOrder_TotalAmount(Order_TotalAmount);

				list.add(loginvo);

			}
			rs.close();
			preStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
