package tw.leonchen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="House")
@Component
public class HouseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int houseid;
	private String housename;

	@Id @Column(name = "HOUSEID")
	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	@Id @Column(name = "HOUSENAME")
	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

}
