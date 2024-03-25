package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//DAO (Data Access Object)
//데이터베이스의 데이터에 접근하는 작업
//데이터 액세스 로직과 비즈니스 로직을 분리하여 사용하기 위함.
public class userDAO {
	private static userDAO instance = new userDAO();
	public static userDAO getInstance() {
		return instance;
	}
	private userDAO() { }
	
	public userVO loginUser(Connection conn, String id) throws SQLException {
		// userid로 정보 조회
		StringBuffer query = new StringBuffer();
		query.append("SELECT user_id");
		query.append("     , user_pw");
		query.append("     , user_nm");
		query.append(" FROM tb_user");
		query.append(" WHERE user_id= ? ");
		query.append(" AND use_yn = 'Y'");
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		userVO vo = new userVO();
		while(rs.next()) {
			vo.setUserId(rs.getString("user_id"));
			vo.setUserPw(rs.getString("user_pw"));
			vo.setUserNm(rs.getString("user_nm"));
		}
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		return vo;
	}
	
	// 회원가입
	public int insertUser(Connection conn, userVO vo) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO tb_user (user_id, user_pw, create_dt)");
		query.append(" VALUES(?,?, sysdate)");
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, vo.getUserId());
		ps.setString(2, vo.getUserPw());
		int cnt = ps.executeUpdate();
		if(ps != null) ps.close();
		
		return cnt;
	}
	// 회원정보 수정(UPDATE)
		public int updateUser(Connection conn, userVO vo) throws SQLException {
			StringBuffer query = new StringBuffer();
			
			query.append(" UPDATE tb_user SET user_nm = ?");
			query.append(" WHERE user_id = ?");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			ps.setString(idx++, vo.getUserNm());
			ps.setString(idx++, vo.getUserId());
			
			int cnt = ps.executeUpdate();
			if(ps != null) ps.close();
			
			return cnt;
		}
		
		// bbs 조회
		public ArrayList<BbsVO> bbsList(Connection conn) throws SQLException{
			StringBuffer query = new StringBuffer();
			query.append(" SELECT (SELECT name");
			query.append("        FROM stock");
			query.append("        WHERE code = a.code) as nm");
			query.append("        ,a.title");
			query.append("        ,a.read_count");
			query.append("        ,TO_CHAR(a.update_dt, 'YYYYMMDD HH24:MI:SS') as update_dt");
			query.append(" FROM bbs a");
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			ArrayList<BbsVO> arr = new ArrayList<BbsVO>();
			while(rs.next()) {
				BbsVO vo = new BbsVO();
				vo.setNm(rs.getString("nm"));
				vo.setTitle(rs.getString("title"));
				vo.setReadCount(rs.getString("read_count"));
				vo.setUpdateDt(rs.getString("update_dt"));
				arr.add(vo);
			}
			if(st != null) st.close();
			if(rs != null) rs.close();			
			return arr;
		}
}
