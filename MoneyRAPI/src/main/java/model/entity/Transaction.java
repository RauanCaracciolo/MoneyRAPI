package model.entity;

public class Transaction {
	private int id;
	private Double value;
	private String desc;
	private String type;
	private String cat;
	private String time;
	
	public Transaction(Double value,String desc, String type, String cat, String time) {
		setValue(value);
		setDesc(desc);
		setType(type);
		setCat(cat);
		setTime(time);
	}
	public Transaction(int id, Double value,String desc, String type, String cat, String time) {
		setId(id);
		setValue(value);
		setDesc(desc);
		setType(type);
		setCat(cat);
		setTime(time);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
