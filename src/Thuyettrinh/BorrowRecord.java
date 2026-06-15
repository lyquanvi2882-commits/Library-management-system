package Thuyettrinh;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate; //Thư viện để hiện thị ngày

class BorrowRecord {
	String BorrowName;
	LocalDate BorrowDate;
	String BorrowIDbook;
	String BorrowNamebook;
	public BorrowRecord(String name, String ID, String title) {
		this.BorrowName= name;
		this.BorrowIDbook= ID;
		this.BorrowNamebook= title;
		this.BorrowDate= LocalDate.now();
	}
	
}