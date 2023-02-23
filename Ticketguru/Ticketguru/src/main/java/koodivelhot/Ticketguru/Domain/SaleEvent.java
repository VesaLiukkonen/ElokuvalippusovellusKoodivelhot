package koodivelhot.Ticketguru.Domain;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import koodivelhot.Ticketguru.Domain.PlaceOfEvent.Venue;

@Entity
public class SaleEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saleid;
	private Date saledate;
	private Time saletime;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "userid") // myyjä joka on tehnyt myyntitapahtuman
    private AppUser user;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "presaleticketid")
	private List<PreSaleTicket> presaletickets;

	public SaleEvent(Long saleid, Date saledate, Time saletime, AppUser user) {
		super();
		this.saleid = saleid;
		this.saledate = saledate;
		this.saletime = saletime;
		this.user = user;
	}

	public Long getSaleid() {
		return saleid;
	}

	public void setSaleid(Long saleid) {
		this.saleid = saleid;
	}

	public Date getSaledate() {
		return saledate;
	}

	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}

	public Time getSaletime() {
		return saletime;
	}

	public void setSaletime(Time saletime) {
		this.saletime = saletime;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}
	
	
}
