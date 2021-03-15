package Team_project2_fin;

import java.sql.*;

public class JoinDAO {
	//3. 클래스변수 선언
		Connection con = null;  //오라클 접속에 필요
		PreparedStatement preStmt = null; //SQL문 실행에 필요
		ResultSet rs = null; //쿼리문 처리 후 결과값 저장에 필요
		int cnt = 0;	

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
		//회원가입시 회원정보 삽입
		public void addMember(String userId, String userPw, String userName, String identification, String userPhoneNum, String userAd) {
			try {
				conn();
									//SQL쿼리문의 컬럼명을 가져와야 한다.
				String userInsert = "INSERT INTO users(user_Id, user_Pw, user_Name, user_identification, user_PhoneNum, user_Ad) "
						+ " VALUES(?,?,?,?,?,?)";
				preStmt = con.prepareStatement(userInsert); //pre는 statement에 쿼리문을 넣는다.
				//for (int i = 0; i < 100; i++) {
					preStmt.setString(1, userId);
					preStmt.setString(2, userPw);
					preStmt.setString(3, userName);
					preStmt.setString(4, identification);
					preStmt.setString(5, userPhoneNum);
					preStmt.setString(6, userAd);
//				}
				preStmt.executeUpdate(); //insert 와 update는 이걸로 그냥은 여기에 쿼리문을 넣는다.
				preStmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		//회원 정보 조회
		public JoinVO listMember() {
//			List list = new ArrayList();
			JoinVO vo = new JoinVO();
			try {
				conn();
				String userSelect="SELECT * FROM member";
				preStmt = con.prepareStatement(userSelect);
				rs = preStmt.executeQuery();
				while(rs.next()) {
					String userId = rs.getString("userId");
					String userPw = rs.getString("userPw");
					String userName = rs.getString("userName");
					String identification = rs.getString("identification");
					String userPhoneNum = rs.getString("userPhoneNum");
					String userAd = rs.getString("userAd");

					vo.setuserId(userId);
					vo.setuserPw(userPw);
					vo.setuserName(userName);
					vo.setidentification(identification);
					vo.setuserPhoneNum(userPhoneNum);
					vo.setuserAd(userAd);
//					list.add(vo);

				 }
				rs.close();
				preStmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return vo;
		}

	}
