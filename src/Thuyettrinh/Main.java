package Thuyettrinh;
import java.util.Scanner; // Nhập thư viện Scanner để đọc dữ liệu từ bàn phím

	// Lớp Main chứa hàm main để chạy toàn bộ chương trình
	public class Main {
	    public static void main(String[] args) {
	        Library library = new Library(); // Tạo một đối tượng thư viện mới
	        Scanner scanner = new Scanner(System.in); // Tạo đối tượng Scanner để nhận dữ liệu nhập vào
	        int choice; // Biến lưu trữ lựa chọn menu của người dùng
	        
	     // Tạo sẵn một vài cuốn sách mẫu để kiểm tra hệ thống nhanh hơn
	     // Tạo sẵn một vài cuốn sách mẫu để kiểm tra hệ thống nhanh hơn
	        library.addBook(new Book("B01", "Lập trình Java", "Nguyễn Văn A", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B02", "Cấu trúc dữ liệu", "Trần Thị B", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B03", "Lập trình hướng đối tượng", "Bùi Anh C", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B04", "Quẳng gánh lo đi mà vui sống", "Dale Carnegie", BookGenre.PHAT_TRIEN_BAN_THAN));
	        library.addBook(new Book("B05", "Đắc nhân tâm", "Dale Carnegie", BookGenre.PHAT_TRIEN_BAN_THAN));
	        library.addBook(new Book("B06", "Cấu trúc dữ liệu và Giải thuật với C++", "Nguyễn Đức Nghĩa", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B07", "Nhập môn Trí tuệ nhân tạo", "Phan Huy Khánh", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B08", "Mã sạch - Clean Code", "Robert C. Martin", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B09", "Thiết kế và tối ưu cơ sở dữ liệu", "Lê Tiến Thường", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B10", "Lập trình Python cơ bản", "Guido van Rossum", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B11", "Tư duy lập trình và giải quyết bài toán", "Trần Đan Thư", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B12", "Hạt giống tâm hồn", "Many Authors", BookGenre.PHAT_TRIEN_BAN_THAN));
	        library.addBook(new Book("B13", "Lập trình Web với JavaScript", "Brendan Eich", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B14", "Kiến trúc máy tính và Hệ điều hành", "Nguyễn Kim Khánh", BookGenre.KHOA_HOC_CONG_NGHE));
	        library.addBook(new Book("B15", "Hiểu về trái tim", "Thích Minh Niệm", BookGenre.KHOA_HOC_XA_HOI));
	        // Vòng lặp do-while để hiển thị menu liên tục cho đến khi người dùng chọn thoát
	        do {
	            // Hiển thị giao diện menu điều khiển
	            System.out.println("\n===== HỆ THỐNG QUẢN LÝ THƯ VIỆN =====");
	            System.out.println("1. Thêm sách mới");
	            System.out.println("2. Hiển thị danh sách sách");
	            System.out.println("3. Tìm kiếm sách theo tên hoặc ID");
	            System.out.println("4. Mượn sách");
	            System.out.println("5. Trả sách");
	            System.out.println("6. Xuất danh sách sách đã mượn");
	            System.out.println("7. Tìm danh mục sách");
	            System.out.println("8. Hiện thị sách của tác giả");
	            System.out.println("0. Thoát chương trình");
	            System.out.print("Vui lòng chọn chức năng (0-8): ");
	try {
	    choice = scanner.nextInt(); // Thử đọc số nguyên
	    scanner.nextLine(); // Xóa bộ nhớ đệm
	} catch (Exception e) {
	    System.out.println("Lỗi nguy hiểm: Vui lòng chỉ nhập số từ 0 đến 8, không nhập chữ!");
	    scanner.nextLine(); // Xóa ký tự chữ bị lỗi ra khỏi bộ nhớ đệm để tránh lặp vô hạn
	    choice = -1; // Gán tạm choice bằng -1 để switch-case nhảy vào phần default và hiện lại menu
	}
	            // Cấu trúc switch-case để xử lý hành động dựa trên lựa chọn của người dùng
	            switch (choice) {
	                case 0:
                    // Thông báo thoát chương trình
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống! Tạm biệt.");
                    break;

	                case 1:
	                    // Nhập thông tin để thêm sách mới
	                    System.out.print("Nhập mã sách: ");
	                    String id = scanner.nextLine();
	                    System.out.print("Nhập tên sách: ");
	                    String title = scanner.nextLine();
	                    System.out.print("Nhập tên tác giả: ");
	                    String author = scanner.nextLine();
	                    // Hiển thị danh mục
	                    library.displayAllBookgenre();
	                    System.out.print("Chọn danh mục (1-" + BookGenre.values().length + "): ");

	                    BookGenre[] genres = BookGenre.values();
	                    int genreChoice = -1;
	                    while (genreChoice < 1 || genreChoice > genres.length) {
	                        try {
	                            genreChoice = scanner.nextInt();
	                            scanner.nextLine();
	                            if (genreChoice < 1 || genreChoice > genres.length) {
	                                System.out.print("Không hợp lệ, nhập lại: ");
	                            }
	                        } catch (Exception e) {
	                            System.out.print("Chỉ nhập số, nhập lại: ");
	                            scanner.nextLine();
	                            genreChoice = -1;
	                        }
	                    }
	                 // Tạo đối tượng sách mới và thêm vào thư viện
	                    library.addBook(new Book(id, title, author, genres[genreChoice - 1]));
	                    break;

	                case 2:
	                    // Gọi hàm hiển thị toàn bộ sách
	                    library.displayAllBooks();
	                    break;

	                case 3:
	                    // Nhập từ khóa và gọi hàm tìm kiếm	
	                	System.out.println("Bạn muốn tìm sách theo tên hay ID: ");
	                	String search= scanner.nextLine();
	                	if (search.equals("tên")) {
	                        System.out.print("Nhập tên sách cần tìm: ");
	                        String searchTitle = scanner.nextLine();
	                        library.searchBookByTitle(searchTitle);
	                	}
	                	else {
	                		System.out.println("Nhập ID của sách: ");
	                		String searchID= scanner.nextLine();
	                		library.searchBookbyID(searchID);
	                	}
	                    break;

	                case 4:
	                    // Nhập mã sách để mượn
	                 	System.out.println("Vui lòng nhập tên để mượn sách: ");
	                	    String borrowerName= scanner.nextLine();
	                	    library.displayBookhasnotbeenBorrowed();
	                    System.out.print("Nhập mã sách muốn mượn: ");
	                    String borrowId = scanner.nextLine();
	                    library.borrowBook(borrowerName, borrowId);
	                    break;

	                case 5:
	                    // Nhập mã sách để trả
	                    System.out.print("Nhập mã sách muốn trả: ");
	                    String returnId = scanner.nextLine();
	                    library.returnBook(returnId);
	                    break;
	                case 6:
	                	    System.out.println("Vui lòng nhập tên: ");
	                	    String br= scanner.nextLine();
	                	    library.showTheBorrowRecord(br);
	                	    break;
	                case 7: 
	                	    library.displayAllBookgenre();
	                	    System.out.println("Vui lòng chọn theo thứ tự trong danh mục: ");
	                	    BookGenre[] genre = BookGenre.values();
	                	    int genreChoice7= -1;
	                	    //Kiểm tra tính hợp lệ
	                	    while (genreChoice7 < 1 || genreChoice7 > genre.length) {
	                	    	try {
	                	    		genreChoice7= scanner.nextInt();
	                	    		scanner.nextLine();
	                	    		if (genreChoice7 < 1 || genreChoice7 > genre.length) {
	                	    			System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại từ (1 - " + genre.length + ")");
	                	    		}
	                	    	}
	                	    	catch (Exception e){
	                	    		System.out.println("Vui lòng chỉ nhập số từ (1 - " + genre.length + ")");
	                	    		scanner.nextLine();
	                	    		genreChoice7= -1;
	                	    	}
	                	    }
	                	    library.displayBookgenre(genre[genreChoice7 -1]);
	                case 8: 
	                	    System.out.println("Nhập tên tác giả bạn muốn tìm: ");
	                	    String Author= scanner.nextLine();
	                	    library.displayAuthorBook(Author);
	                	    break;
	                default:
	                    // Xử lý trường hợp người dùng nhập số không nằm trong khoảng 0-5
	                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại từ 0 đến 5.");
	            }
	        } while (choice != 0); // Vòng lặp tiếp tục chạy nếu lựa chọn khác 0

	        scanner.close(); // Đóng đối tượng Scanner để giải phóng tài nguyên hệ thống
	    }
	}
	