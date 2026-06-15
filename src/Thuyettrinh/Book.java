package Thuyettrinh;

// Lớp Book đại diện cho một cuốn sách trong thư viện
class Book {
    // Các thuộc tính (biến thành viên) của cuốn sách
    private String id;          // Mã số sách
    private String title;       // Tên cuốn sách
    private String author;      // Tên tác giả
    private BookGenre bookgenre;
    private boolean isBorrowed; // Trạng thái: true nếu đã được mượn, false nếu chưa

    // Hàm khởi tạo (Constructor) để tạo một đối tượng sách mới
    public Book(String id, String title, String author, BookGenre bookgenre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.bookgenre= bookgenre;
        this.isBorrowed = false; // Khi mới thêm vào thư viện, sách mặc định chưa bị mượn
    }

    // Các hàm Getter và Setter để truy cập và cập nhật dữ liệu của sách
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
      	return author;
    }
    public BookGenre getBookgenre() {
    	   return bookgenre;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Hàm thay đổi trạng thái mượn sách
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    // Hàm hiển thị thông tin chi tiết của cuốn sách dưới dạng chuỗi văn bản
    public void displayInfo() {
        // Sử dụng toán tử điều kiện để hiển thị trạng thái sách bằng tiếng Việt
        String status = isBorrowed ? "Đã được mượn" : "Còn sách";
        System.out.println("Mã sách: " + id + " | Tên: " + title + " | Tác giả: " + author + " | Trạng thái: " + status);
    }
}
