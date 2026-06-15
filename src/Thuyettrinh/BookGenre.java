package Thuyettrinh;
public enum BookGenre {
	KHOA_HOC_CONG_NGHE("Khoa học & Công nghệ (Science & Technology)"),
    KINH_TE_QUAN_LY("Kinh tế & Quản lý (Economics & Business)"),
    KHOA_HOC_XA_HOI("Khoa học Xã hội & Nhân văn (Social Sciences)"),
    PHAT_TRIEN_BAN_THAN("Phát triển Bản thân & Nghệ thuật sống (Self-Help & Life)"),
    VAN_HOC_NGHE_THUAT("Văn học & Nghệ thuật (Literature & Arts)");
	private final String displayName;
	BookGenre(String displayName){
		this.displayName= displayName;
	}
	public String getDisplayName(){
		return displayName;
	}
}
