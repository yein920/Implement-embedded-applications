package Team_project2_fin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
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
	
	public List restList(String category) {
		List list = new ArrayList();

		try {
			conn();
			// 셀렉트문 입력
			String userSelect = "SELECT rest_name, minprice, category" +
								" FROM restaurant " +
								" WHERE category = ?";
			
			preStmt = con.prepareStatement(userSelect);
			preStmt.setString(1, category);
			rs = preStmt.executeQuery();

			while (rs.next()) {
	
				String RestName = rs.getString("rest_name");
				String Category = rs.getString("category");
				int MinPrice = rs.getInt("minprice");
				
				VO vo = new VO();
				vo.setRestName(RestName);
				vo.setMinPrice(MinPrice);
				vo.setCategory(Category);

				list.add(vo);
			
			}
			rs.close();
			preStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//각 카테고리 식당 리스트 select 검색
	
	public List restInfo(String Rest) {
		List list = new ArrayList();

		
		try {
			conn();
			// 셀렉트문 입력
			String userSelect = "SELECT  r.rest_reginum, r.rest_name, r.rest_ad, r.rest_phonenum, u.food_num, u.foodname, u.unitprice, r.minprice" +
								" FROM restaurant r, unitrestmenu u" +
								" WHERE r.rest_reginum = u.rest_reginum" +
								" AND r.rest_name = ?";
			
			preStmt = con.prepareStatement(userSelect);
			preStmt.setString(1, Rest);
			rs = preStmt.executeQuery();

			while (rs.next()) {
	
				String RestName = rs.getString("rest_name");
				String RestAddress = rs.getString("rest_ad");
				String FoodName = rs.getString("foodname");
				String Phone = rs.getString("rest_phonenum");
				int RestRegiNum = rs.getInt("rest_reginum");
				int MinPrice = rs.getInt("minprice");
				int UnitPrice = rs.getInt("unitprice");
				int FoodNum = rs.getInt("food_num");
				VO vo = new VO();
				vo.setRestName(RestName);
				vo.setRestAddress(RestAddress);
				vo.setFoodName(FoodName);
				vo.setRestRegiNum(RestRegiNum);
				vo.setPhone(Phone);
				vo.setMinPrice(MinPrice);
				vo.setUnitPrice(UnitPrice);
				vo.setFoodNum(FoodNum);
				list.add(vo);

			}
			rs.close();
			preStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//각 카테고리 식당 메뉴 select 검색
	
	public List logUserInfo(String UserId) {
		List list = new ArrayList();
		
		try {
			conn();
			// 셀렉트문 입력
			String userSelect = "SELECT user_phonenum, user_ad" +
								" FROM users" +
								" WHERE user_id = ?";
			
			preStmt = con.prepareStatement(userSelect);
			preStmt.setString(1, UserId);
			rs = preStmt.executeQuery();

			while (rs.next()) {
	
				String UserPhoneNum = rs.getString("user_phonenum");
				String UserAddress = rs.getString("user_ad");
			
				VO vo = new VO();
	
				vo.setUserPhoneNum(UserPhoneNum);
				vo.setUserAddress(UserAddress);
	
				list.add(vo);

			}
			rs.close();
			preStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//로그인한 사람의 정보 검색 
	
	public int lastOrderNum() {
		//List list = new ArrayList();
		int OrderNum = 0;
		try {
			conn();
			// 셀렉트문 입력
			String userSelect = "SELECT MAX(order_num)" +
								" FROM orders"; 
							
			
			preStmt = con.prepareStatement(userSelect);
			//preStmt.setString(1, "orders");
			rs = preStmt.executeQuery();

			while (rs.next()) {
	
				OrderNum = rs.getInt("MAX(order_num)");
				VO vo = new VO();
				vo.setOrderNum(OrderNum);
				System.out.println();
				//list.add(vo);

			}
			rs.close();
			preStmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return list;
		return OrderNum;
	}//로그인한 사람의 정보 검색 
	
	
	public void addOrder(int LastOrder, String UserId, int RestRegiNum,  int Total ) {
		try {
			//for (int i = 0; i < basket.size(); i++) {
			conn();
			String userInsert = "INSERT INTO orders(order_num, user_id, rest_reginum, order_totalamount) VALUES(?,?,?,?)";
			preStmt = con.prepareStatement(userInsert); //pre는 statement에 쿼리문을 넣는다.
			
		
				preStmt.setInt(1, LastOrder);
				preStmt.setString(2, UserId);
				preStmt.setInt(3, RestRegiNum);
				preStmt.setInt(4, Total);
				
			preStmt.executeUpdate(); //insert 와 update는 이걸로 그냥은 여기에 쿼리문을 넣는다.
			preStmt.close();
			con.close();
		//	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //orders 테이블에 추가 
	
	
	public void addOrderDetail(ArrayList<VO> basket, int LastOrder) {
		try {
			for (int i = 0; i < basket.size(); i++) {
			conn();
			String userInsert = "INSERT INTO ordersdetail(order_num, food_num, order_food) VALUES(?,?,?)";
			preStmt = con.prepareStatement(userInsert); //pre는 statement에 쿼리문을 넣는다.
			
		
				preStmt.setInt(1, LastOrder );
				preStmt.setInt(2, basket.get(i).getFoodNum());
				preStmt.setString(3, basket.get(i).getFoodName());
			

			preStmt.executeUpdate(); //insert 와 update는 이걸로 그냥은 여기에 쿼리문을 넣는다.
			preStmt.close();
			con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} //주문정보 데베로넘기기 


	
}
