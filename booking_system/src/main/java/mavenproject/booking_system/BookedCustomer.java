package mavenproject.booking_system;

public class BookedCustomer {
	String cid;
	String cname;
	String cemail;
	String cdate;
	public BookedCustomer(String cid, String cname, String cemail, String cdate) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.cdate = cdate;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	

}
