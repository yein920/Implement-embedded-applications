package Team_project2_fin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Team_project2_fin.ManagerVO;

public class ManagerDAO {
	//1. 클래스변수 선언
	Connection con = null;  //오라클 접속에 필요
	PreparedStatement preStmt = null; //SQL문 실행에 필요
	ResultSet rs = null; //쿼리문 처리 후 결과값 저장에 필요
	//2. 오라클접속
	void conn() {
			//1.오라클 접속에 필요한 클래스를 메모리에 로딩
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//2.url,id,pass 저장
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "bitTest";
			String pass = "bitTest";

			//4. 오라클 접속
			try {
				con = DriverManager.getConnection(url,id,pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	//----------------------상우 시작----------------------------------
	//1.조회(회원정보)
	public List listMember() {
		List list = new ArrayList();
		try {
			conn();
			String query="SELECT * FROM users";
			preStmt = con.prepareStatement(query);
			rs = preStmt.executeQuery();
			while(rs.next()) { 
				String UserId = rs.getString(1);
				String UserPw = rs.getString(2);
				String UserName = rs.getString(3);
				String UserIdentication = rs.getString(4);
				String UserPhoneNum = rs.getString(5);
				String UserAd = rs.getString(6);
				ManagerVO mangersvo = new ManagerVO();
				mangersvo.setUserId(UserId);
				mangersvo.setUserPw(UserPw);
				mangersvo.setUserName(UserName);
				mangersvo.setUserIdentication(UserIdentication);
				mangersvo.setUserPhoneNum(UserPhoneNum);
				mangersvo.setUserAd(UserAd);
				list.add(mangersvo);

			 }
			rs.close();
			preStmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//2.조회(주문정보)
	public List listOrders(String name) {
		List list = new ArrayList();
		try {
			conn();
			String query="SELECT order_num, rest_reginum, rest_name, order_food, order_totalamount\r\n" + 
					"FROM restaurant \r\n" + 
					"JOIN orders USING(rest_reginum)\r\n" + 
					"JOIN ordersdetail USING(order_num)\r\n" + 
					"WHERE order_num IN (SELECT order_num "
					+ "FROM users JOIN orders USING(user_id) WHERE user_name = ?)";
			preStmt = con.prepareStatement(query);
			preStmt.setString(1, name);
			
			rs = preStmt.executeQuery();
			while(rs.next()) { 
				int ORDER_NUM = rs.getInt(1);
				int REST_REGINUM = rs.getInt(2);
				String REST_NAME = rs.getString(3);
				String ORDER_FOOD = rs.getString(4);
				int ORDER_TOTALAMOUNT = rs.getInt(5);
				ManagerVO mangersvo = new ManagerVO();
				mangersvo.setORDER_NUM(ORDER_NUM);
				mangersvo.setREST_REGINUM(REST_REGINUM);
				mangersvo.setREST_NAME(REST_NAME);
				mangersvo.setORDER_FOOD(ORDER_FOOD);
				mangersvo.setORDER_TOTALAMOUNT(ORDER_TOTALAMOUNT);
				list.add(mangersvo);

			 }
			rs.close();
			preStmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 3. 회원정보 수정(ok)
	public void updateMember(ManagerVO vo) {
		try {
			conn();
			String query="UPDATE users SET user_id=?, user_pw=?, "
					+ "user_name=?, user_identication=? ,"
					+ "user_phonenum=?, user_ad=? WHERE user_id=?";
			preStmt = con.prepareStatement(query);
			preStmt.setString(1, vo.getUserId());
			preStmt.setString(2, vo.getUserPw());
			preStmt.setString(3, vo.getUserName());
			preStmt.setString(4, vo.getUserIdentication());
			preStmt.setString(5, vo.getUserPhoneNum());
			preStmt.setString(6, vo.getUserAd());		
			preStmt.setString(7, vo.getUserId());		
			int cnt = preStmt.executeUpdate();
			if(cnt != 0) {
			System.out.println("<정보 수정이 완료되었습니다.>");
			}
			rs.close();
			preStmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

	//3.회원별 누적 구매액 순위 조회(ok)
		public List listUserAmountRank() {
			List list = new ArrayList();
			try {
				conn();
				String query="SELECT user_id, sum(order_totalamount),"
								+ "RANK() OVER (ORDER BY sum(order_totalamount)DESC) 구매순위 "
								+ "FROM orders "
								+ "GROUP BY user_id "
								+ "ORDER BY 2 DESC";                                            //여기선 세미콜론 안붙임!!!
				preStmt = con.prepareStatement(query);
				rs = preStmt.executeQuery();
				while(rs.next()) { 
					String UserId = rs.getString(1);
					int Sum_totalamount = rs.getInt(2);
					int SUM_RANK = rs.getInt(3);
					ManagerVO mangersvo = new ManagerVO();
					mangersvo.setUSER_ID(UserId);;
					mangersvo.setSUM_TOTALAMOUNT(Sum_totalamount);
					mangersvo.setSUM_RANK(SUM_RANK);
					list.add(mangersvo);
				 }
				rs.close();
				preStmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
	//4.식당별 누적 주문 금액 순위 조회 
	public List listRestAmount() {
		List list = new ArrayList();
		try {
			conn();
			String query="SELECT rest_reginum, rest_name, SUM(order_totalamount), "
					+ "RANK() OVER(ORDER BY SUM(order_totalamount) DESC) \"총 주문액 순위\"\r\n" + 
					"FROM restaurant\r\n" + 
					"JOIN orders USING(rest_reginum)\r\n" + 
					"GROUP BY rest_reginum, rest_name";
			preStmt = con.prepareStatement(query);
			rs = preStmt.executeQuery();
			while(rs.next()) { 
				int REST_REGINUM = rs.getInt(1);
				String REST_NAME = rs.getString(2);
				int SUM_TOTALAMOUNT = rs.getInt(3);
				int SUM_RANK = rs.getInt(4);
				
				ManagerVO vo = new ManagerVO();
				vo.setREST_REGINUM(REST_REGINUM);
				vo.setREST_NAME(REST_NAME);
				vo.setSUM_TOTALAMOUNT(SUM_TOTALAMOUNT);
				vo.setSUM_RANK(SUM_RANK);
				
				list.add(vo);

			 }
			rs.close();
			preStmt.close();
			con.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//5. 음식별 주문건수 순위 조회(많은순)
		public List FoodCountRank() {
			List list = new ArrayList();
			try {
				conn();
				String query="SELECT rest_reginum, rest_name, order_food, count(order_num),"
						+ "RANK() OVER (ORDER BY count(order_food) DESC) "
						+ "FROM restaurant "
						+ "JOIN unitRestMenu USING(rest_reginum) "
						+ "JOIN ordersdetail USING(food_num) "
						+ "GROUP BY rest_reginum, rest_name, order_food"; 
				preStmt = con.prepareStatement(query);
				rs = preStmt.executeQuery();
				while(rs.next()) { //테이블의 행단위로 묶어서 쌓여있고 그걸 하나씩 가져오는듯?
					int REST_REGINUM = rs.getInt(1);
					String REST_NAME = rs.getString(2);
					String ORDER_FOOD = rs.getString(3);
					int COUNT_FOOD = rs.getInt(4);
					int COUNT_RANK = rs.getInt(5);
					
					ManagerVO mangersvo = new ManagerVO();
					mangersvo.setREST_REGINUM(REST_REGINUM);
					mangersvo.setREST_NAME(REST_NAME);
					mangersvo.setORDER_FOOD(ORDER_FOOD);
					mangersvo.setCOUNT_FOOD(COUNT_FOOD);
					mangersvo.setCOUNT_RANK(COUNT_RANK);
					list.add(mangersvo);
				 }
				rs.close();
				preStmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
	//6. 음식별 주문금액 순위 조회
	public List FoodAmountRank() {
		List list = new ArrayList();
		
		try {
			conn();
			String query = "SELECT rest_reginum, rest_name, order_food, SUM(unitPrice), "
					+ "RANK() OVER(ORDER BY SUM(unitPrice) DESC) " 
					+"FROM restaurant " 
					+"JOIN unitRestMenu USING(rest_reginum) " 
					+"JOIN ordersdetail USING(food_num) " 
					+"GROUP BY rest_reginum, rest_name,order_food";
			preStmt= con.prepareStatement(query);
			rs = preStmt.executeQuery();
			while(rs.next()) {
				int REST_REGINUM = rs.getInt(1);
				String REST_NAME = rs.getString(2);
				String ORDER_FOOD = rs.getString(3);
				int SUM_TOTALAMOUNT = rs.getInt(4);
				int SUM_RANK = rs.getInt(5);
					
				ManagerVO mangersvo = new ManagerVO();
				mangersvo.setREST_REGINUM(REST_REGINUM);
				mangersvo.setREST_NAME(REST_NAME);
				mangersvo.setORDER_FOOD(ORDER_FOOD);
				mangersvo.setSUM_TOTALAMOUNT(SUM_TOTALAMOUNT);
				mangersvo.setSUM_RANK(SUM_RANK);			
				list.add(mangersvo);
			}
			rs.close();
			preStmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
	
	
	public List recommendFood() {
		List list = new ArrayList();
		
		try {
			conn();
			String query = "SELECT rest_name, order_food, COUNT(food_num)\r\n" + 
					"FROM ordersDetail\r\n" + 
					"JOIN unitrestmenu USING(food_num)\r\n" + 
					"JOIN restaurant USING(rest_reginum)\r\n" + 
					"GROUP BY rest_name, order_food\r\n" + 
					"ORDER BY 3 DESC";
			preStmt= con.prepareStatement(query);
			rs = preStmt.executeQuery();
			while(rs.next()) {
				String REST_NAME = rs.getString(1);
				String ORDER_FOOD = rs.getString(2);
				int COUNT_FOOD = rs.getInt(3);
					
				ManagerVO mangersvo = new ManagerVO();
				mangersvo.setREST_NAME(REST_NAME);
				mangersvo.setORDER_FOOD(ORDER_FOOD);
				mangersvo.setCOUNT_FOOD(COUNT_FOOD);
				list.add(mangersvo);
			}
			rs.close();
			preStmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	//관리자 아이디 
	public List managerCheck() {
		List list = new ArrayList();
		
		try {
			conn();
			String query="SELECT user_id, user_pw FROM users WHERE user_id = 'system'";
			preStmt = con.prepareStatement(query);
			rs = preStmt.executeQuery();
			while(rs.next()) { //테이블의 행단위로 묶어서 쌓여있고 그걸 하나씩 가져오는듯?
				String UserId = rs.getString(1);
				String UserPw = rs.getString(2);
				ManagerVO mangersvo = new ManagerVO();
				mangersvo.setUserId(UserId);
				mangersvo.setUserPw(UserPw);
				list.add(mangersvo);

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
