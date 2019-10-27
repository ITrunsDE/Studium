import java.util.Date;

public class LogEntry {
	
	private Date date;
	private Date time;
	private int id1;
	private int id2;
	private String type;
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date parsedTime) {
		this.time = parsedTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return this.getDate() + "<->"+ this.getId1() + "<->"+ this.getId2() + "<->"+ this.getType() + "<->" + this.getText();
	}
	
}
