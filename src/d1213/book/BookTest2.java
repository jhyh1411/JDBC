package d1213.book;

import java.sql.SQLException;

public class BookTest2 {

	public static void main(String[] args) {

		BookRentDao dao = BookRentDao.getInstance();
		System.out.println("::: 대여 :::");
//		Scanner sc = new Scanner(System.in);
		int mem_idx = 10002;
		String bcode ="C1101";
		try {
			if(!dao.isAvailableMember(mem_idx))
				System.out.println("회원님은 대여 중인 도서가 있어 추가 대여 불가!!");
			else if(!dao.isAvailableBook(bcode))
				System.out.println("이 책은 대여 중 입니다.!!");
			else { 
				dao.rentBook(mem_idx, bcode);
				System.out.println(mem_idx + " 회원 "+ bcode  + "도서 대여처리 완료!!");
			}	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
	
	}

}