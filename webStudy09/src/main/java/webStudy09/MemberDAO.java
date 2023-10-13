package webStudy09;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//db 접속 연동
public class MemberDAO {

	private MemberDAO() {
		
	}
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		System.out.println("con :" + conn);
		return conn;
	}
	//로그인 성공 여부
	public int userCheck(String userid, String pwd) {
		String sql = "select pwd from member where userid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			if(rs.next()) {//아이디는 맞다
				if(rs.getString("pwd").equals(pwd)) {
					result = 1;
				}else {
					result = 0;
				}	
			}else {
					result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	//특정 userid 일치하는 모든 데이터 vo 담는다
	public MemberVO getMember(String userid) {
		String sql = "select * from member where userid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setEmail(rs.getString("email"));
				vo.setPwd(rs.getString("pwd"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
				if(ps != null) ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return vo;
	}
	//userid 중복체크
	public int confirmId(String userid) {
		return 0;
	}
	//데이터 insert
	public void insertMember(MemberVO vo) {
		
	}
	//데이터 update
	public void updateMember(MemberVO vo) {
		
	}
}
