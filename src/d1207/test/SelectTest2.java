package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest2 {

	public static void main(String[] args) {
		//java.sql 패키지의 인터페이스는 자바 API에 구현클래스는 없다. 연관된 다른객체를 통해서 객체가 생성.
		Connection conn = OracleUtil.getConnection();
		System.out.println("연결확인");
		System.out.println(conn);
		
		//SQL select 실행 = 새로운 객체 2가지 -> 인터페이스를 통해서 DBMS 종류에 따라 구현체의 객체가 생성
		PreparedStatement pstmt = null;		//sql 실행할 객체를 참조
		ResultSet rs = null;		//select 쿼리 결과 객체를 참조
		String sql = "select * from member_tbl_02";
		
		try {
			pstmt = conn.prepareStatement(sql);	//sql 명령을 인자로 받아 실행할 객체를 생성
			rs = pstmt.executeQuery();			//쿼리 실행하고 그 결과를 객체로 생성하여 rs가 참조변수
			
			//while 문으로 변경
			int cnt=0;
			while(rs.next()) {
//				System.out.println("조회 결과가 있습니까? (첫번째 행)" + rs.next());		//next() 메소드 : 조회결과 다음행을 참조. 참 또는 거짓
//				System.out.println("첫번째 컬럼의 값 : " + rs.getInt(1));
//				System.out.println("두번째 컬럼의 값 : " + rs.getNString(2));
//				System.out.println("세번째 컬럼의 값 : " + rs.getNString(3));
//				System.out.println("네번째 컬럼의 값 : " + rs.getNString(4));
//				System.out.println("다섯번째 컬럼의 값 : " + rs.getDate(5));
//				System.out.println("여섯번째 컬럼의 값 : " + rs.getNString(6));
//				System.out.println("일곱번째 컬럼의 값 : " + rs.getNString(7));
				
			System.out.println(rs.getInt(1) + "\t" + rs.getNString(2) + "\t"
					+ rs.getNString(3) + "\t"
					+ rs.getNString(4) + "\t"
					+ rs.getDate(5) + "\t"
					+ rs.getNString(6) + "\t"
					+ rs.getNString(7));
				cnt++;
				
			}
			System.out.println("조회된 행의 개수 : " + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
/* 쿼리 실행하고 결과를 자바 객체에 저장하는 방법
 * 1) 순수하게 statement 객체 사용   2)프레임워크 : 코딩노가다를 최소로 
 * 3) SQL 이용하지 않고 바로 자바객체와 대입
 * 		
 */
		
		
		
		
		
		
		
		
		OracleUtil.close(conn);
	}
}
