package easymall.po;

public class Products {
	private String id;
	private String name;
	private Double price;
	private String category;
	private Integer pnum;
	private String imgurl;
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Products [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (price != null ? "price=" + price + ", " : "")
				+ (category != null ? "category=" + category + ", " : "") + (pnum != null ? "pnum=" + pnum + ", " : "")
				+ (imgurl != null ? "imgurl=" + imgurl + ", " : "")
				+ (description != null ? "description=" + description : "") + "]";
	}
	
	
	
}
