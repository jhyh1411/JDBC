package d1207.test;

import java.sql.Connection;

import jdbc.util.OracleUtil;

public class OracleUtilTest {

	public static void main(String[] args) {
		
		Connection conn = OracleUtil.getConnection();
		System.out.println("연결확인");
		System.out.println(conn);		//null이 출력되면 연결실패
		
		OracleUtil.close(conn);
	}
}
