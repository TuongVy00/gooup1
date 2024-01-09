package bean;

// Sách giáo khóa
// Book: id, salesPrice, publisher
public class TextBook extends Book{
	private boolean isNew;
	
	public TextBook() {
	}

	public TextBook(String id, double salesPrice, String publisher, boolean isNew) {
		super(id, salesPrice, publisher);
		this.isNew = isNew;
	}
	
	public boolean isNew() {
		return isNew;
	}

	@Override
	public String toString() {
		return getId() + ", " + getSalesPrice() + ", "
				+ getPublisher() + ", " + isNew() + "\n";
	}
}