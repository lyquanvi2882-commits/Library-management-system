package Thuyettrinh;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit; // Thư viện được dùng cho chức năng 4
import java.util.ArrayList;// Nhập thư viện ArrayList để sử dụng danh sách động
import java.util.HashMap; // Library dùng để tìm sách đã tồn tại ở chức năng thêm

// Lớp Library quản lý danh sách các cuốn sách và các thao tác liên quan
class Library {
    // Khai báo một danh sách các đối tượng Book
    private ArrayList<Book> bookList;
    private HashMap<String, Book> map= new HashMap<>();//Dùng cho chức năng 3.1
    private HashMap<String, ArrayList<BorrowRecord>> borrowMap= new HashMap<>();// Dùng cho chức năng 4
    private HashMap<BookGenre, ArrayList<Book>> bookgenreMap= new HashMap<>();// Dùng cho chức năng 7
    private HashMap<String, ArrayList<Book>> authorBookMap= new HashMap<>(); // Chức năng 8
    // Hàm khởi tạo 
    public Library() {
        bookList = new ArrayList<>();
        //Tạo danh mục
        for (BookGenre genre : BookGenre.values()) {
            bookgenreMap.put(genre, new ArrayList<>());
        }
    }

    // 1. Chức năng: Thêm một cuốn sách mới vào thư viện (Đã sửa lỗi trùng mã)
    // Thêm HashMap vào để kiểm tra trùng 
  public void addBook(Book book) {
	String key= book.getId().toUpperCase(); // Chuẩn hóa về chữ hoa
	if (map.containsKey(key)) {
	  System.out.println("Lỗi: Mã sách '" + book.getId() + "' đã tồn tại! Không thể thêm.");
	} else {
	// Nếu không trùng thì mới thêm
    bookList.add(book);
    map.put(key, book);
    bookgenreMap.get(book.getBookgenre()).add(book); // Thêm vào danh mục
    // Thêm sách vào danh sách của từng tác giả
    String author= book.getAuthor().toUpperCase();
    	authorBookMap.putIfAbsent(author, new ArrayList<>()); // Tạo một danh sách sách mới theo tên tác giả nếu tên tác giả chưa nằm trong thư viện
    	authorBookMap.get(author).add(book);
    System.out.println("Thêm sách thành công!");
	}
}
    // 2. Chức năng: Hiển thị toàn bộ sách có trong thư viện
    public void displayAllBooks() {
        // Kiểm tra nếu danh sách trống thì thông báo và thoát hàm
        if (bookList.isEmpty()) {
            System.out.println("Thư viện hiện tại chưa có sách nào.");
            return;
        }
        System.out.println("\n--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
        // Duyệt qua từng cuốn sách trong danh sách và gọi hàm hiển thị thông tin
        for (Book book : bookList) {
            book.displayInfo();
        }
    }

    // 3. Chức năng: Tìm kiếm sách theo tên (không phân biệt chữ hoa, chữ thường)
    public void searchBookByTitle(String title) {
    // Bổ sung kiểm tra nếu người dùng bỏ trống không nhập từ khóa
    if (title.trim().isEmpty()) {
        System.out.println("Vui lòng nhập từ khóa để tìm kiếm!");
        return; 
    }

    boolean found = false; 
    for (Book book : bookList) {
        if (book.getTitle().toUpperCase().contains(title.toUpperCase())) {
            book.displayInfo();
            found = true; 
        }
    }
    if (!found) {
        System.out.println("Không tìm thấy cuốn sách nào có tên: " + title);
    }
}
    //3.1 Bổ sung thêm chức năng tìm sách theo ID
    public void searchBookbyID(String ID) {
    	// Bổ sung kiểm tra nếu người dùng bỏ trống không nhập từ khóa
        if (ID.trim().isEmpty()) {
            System.out.println("Vui lòng nhập từ khóa để tìm kiếm!");
            return; 
        }
        String key= ID.toUpperCase();
        if(map.containsKey(key)){
        	Book searchBook= map.get(key);
        	searchBook.displayInfo();
        } 
        else {
        	System.out.println("Không tìm thấy cuốn sách nào có ID: " + ID);
        	return;
        }
    }

    // 4. Chức năng: Mượn sách dựa vào mã sách (ID)
    // Bổ sung thêm chức năng kiểm tra quá hạn mượn và số lần mượn sách
    public void borrowBook(String name, String ID) {
    	// Check sách có tồn tại không
    	String key= ID.toUpperCase();
    	if(!map.containsKey(key)) {
    		System.out.println("Không có mã ID sách này trong thư viện");
    		return;
    	}
    	//Check sách đã được mượn chưa
    	Book book= map.get(key);
    	if(book.isBorrowed()) {
    		System.out.println("Mã sách có ID:" + ID + " này đã được mượn.");
    		return;
    	}
    	
    	//Check danh sách của người mượn đã có bao nhiêu lần mượn sách và số sách quá hạn ( thời hạn mượn sách là 14 ngày và chỉ mượn được 5 cuốn sách )
    	String Name= name.toUpperCase(); // Đồng bộ chữ viết hoa
    	borrowMap.putIfAbsent(Name, new ArrayList<>());
    	ArrayList<BorrowRecord> danhsachmuon= borrowMap.get(Name);
    	//Check quá hạn
    	for(BorrowRecord v : danhsachmuon) {
        	long songayquahan= ChronoUnit.DAYS.between(v.BorrowDate.plusDays(14), LocalDate.now());
    		if(LocalDate.now().isAfter(v.BorrowDate.plusDays(14))) {
    			System.out.println("Xin lỗi hiện bạn đang có một cuốn sách tên là:  " + v.BorrowNamebook + " mượn từ ngày" +"(" + v.BorrowDate +")" + " và đã quá hạn" + songayquahan + " ngày");
    			return;
    		}	
    	}
    	//Check số sách đã mượn
    	if(danhsachmuon.size() >= 3) {
    		System.out.println("Bạn đã mượn quá 3 cuốn sách không thể mượn thêm");
    		return;
    	}
    	//Cho mượn
    	danhsachmuon.add(new BorrowRecord(name, key, book.getTitle()));
    	book.setBorrowed(true);
    	System.out.println("Bạn đã mượn cuốn '" + book.getTitle() + "' thành công!");
    }
    // 5. Chức năng: Trả sách dựa vào mã sách (ID)
    public void returnBook(String ID) {
    	String key= ID.toUpperCase();
    	Book book= map.get(key);
    	if(book.isBorrowed()) {
    		book.setBorrowed(false);
    		System.out.println("Bạn đã trả cuốn '" + book.getTitle() + "' thành công!");
    	}
    	else {
    		System.out.println("Cuốn sách này hiện đang ở thư viện, không cần trả.");
    	}
    	return;
    }
    //6. Chức năng: Hiện thị danh sách sách đã mượn
    public void showTheBorrowRecord(String name) {
    	if(!borrowMap.containsKey(name)) {
    		System.out.println("Không tìm thấy lịch sử mượn của bạn");
    	}
 	ArrayList<BorrowRecord> danhsachmuon= borrowMap.get(name);
 	System.out.println("=== DANH SÁCH MƯỢN SÁCH CỦA BẠN ===");
 	for(BorrowRecord t : danhsachmuon) {
 		System.out.println("Tên sách" + t.BorrowNamebook + " |Mã sách: " + t.BorrowIDbook + " |Ngày mượn: " + t.BorrowDate + " |Ngày trả: " +t.BorrowDate.plusDays(14));
 		System.out.println();
 	}
    }
    //Hiện thị danh sách sách chưa được mượn
    public void displayBookhasnotbeenBorrowed() {
    	System.out.println("=== Danh sách sách hiện có trong thư viện ===");
    	for(Book book: bookList) {
    		if(!book.isBorrowed()) {
    			System.out.println("Mã sách: " + book.getId() + " | Tên: " + book.getTitle() + " | Tác giả: " + book.getAuthor() );
    		}
    	}
    }
    //7. Chức năng: Hiện thị danh mục sách
    public void displayBookgenre(BookGenre genre) {
    	ArrayList<Book> danhmuc= bookgenreMap.get(genre);
    	if (danhmuc == null || danhmuc.isEmpty()) {
    		System.out.println("Danh mục " + genre.getDisplayName() + " không nằm trong danh mục sách của thư viện");
    		return;
    		}
    	System.out.println("=== Danh mục: " + genre.getDisplayName() + " ===");
    	for(Book book: danhmuc) {
    		book.displayInfo();
    		System.out.println();
    	}
    }
    //7.1. Hiện thị tất cả các danh mục trong thư viện
    public void displayAllBookgenre() {
    	System.out.println("=== Danh mục trong thư viện ===");
    	int i=1;
    	for(BookGenre v : BookGenre.values()) {
    		System.out.println(i + "." + v.getDisplayName());
    		System.out.println();
    		i++;
    	}
    			
    }
    //8. Chức năng: Hiện thị sách theo tên tác giả
    public void displayAuthorBook(String name) {
    	String key= name.toUpperCase();
    	ArrayList<Book> ab= authorBookMap.get(key);
    	if(authorBookMap.containsKey(key)) {
    		for(Book b: ab) {
    			System.out.println("=== Danh sách sách của tác giả " + key + " ===");
    			String status = b.isBorrowed() ? "Đã được mượn" : "Còn sách";
    		    System.out.println("Mã sách: " + b.getId() + " | Tên: " + b.getTitle() + " | Trạng thái: " + status);
    		    System.out.println();
    		}
    	}
    	else {
    		System.out.println("Hiện tại không có cuốn sách nào của tác giả " + key + " trong thư viện.");
    	}
    }
    
}
