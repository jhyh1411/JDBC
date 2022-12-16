package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest3 {

	public static void main(String[] args) {
		Connection conn = OracleUtil.getConnection();
		//\r\n는 줄바꿈(엔터), sql 자바 문자열에서는 꼭 필요한것은 아님(있어도 되고 없어도 됨
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT mt.custno,custname,decode(grade,'A','VIP','B','일반','C','직원') ,psum \r\n"
				+ "FROM MEMBER_TBL_02 mt\r\n"
				+ "JOIN\r\n"
				+ "(\r\n"	
				+	"SELECT custno , sum(price) psum\r\n" 
				+	"FROM MONEY_TBL_02\r\n"
				+	"GROUP BY custno\r\n"
				+ ") sale \r\n"
				+ "ON mt.custno = sale.custno \r\n"
				+ "ORDER BY psum desc";


		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("회원매출 현황");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t"
						+ rs.getNString(2) + "\t"
						+ rs.getNString(3) + "\t"
						+ rs.getInt(4) + "\t");
			}
		} catch (SQLException e) {
			
		}
	}
}

//SELECT mt.custno,custname,decode(grade,'A','VIP','B','일반','C','직원') "등급",psum
//FROM MEMBER_TBL_02 mt
//JOIN
//(	--서브 쿼리
//	SELECT custno , sum(price) psum     -- 별칭에 따옴표 없어야 컬럼명이 됩니다.
//	FROM MONEY_TBL_02 
//	GROUP BY custno
//) sale    -- 1단계 결과에 대한 별칭 sale
//ON mt.custno = sale.custno
//ORDER BY psum desc;