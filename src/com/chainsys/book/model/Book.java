package com.chainsys.book.model;

import java.time.LocalDate;

public class Book {
	private int Bid;
	private String Bname;
	private LocalDate publisherdate;
	
	public void setBId(int Bid) {
		this.Bid=Bid;
	}
	public void setBName(String Bname) {
		this.Bname=Bname;
	}
	public void setPublisherDate(LocalDate publisherdate) {
		this.publisherdate=publisherdate;
	}
	public int getBId() {
		return Bid;
	}
	public String getBName() {
		return Bname;
	}
	public LocalDate getpublisherdate() {
		return publisherdate;
	}
	
	public Book(){
		
	}
	public Book(int Bid,String Bname,LocalDate publisherdate) {
		this.Bid=Bid;
		this.Bname=Bname;
		this.publisherdate=publisherdate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Bid;
		result = prime * result + ((Bname == null) ? 0 : Bname.hashCode());
		result = prime * result + ((publisherdate == null) ? 0 : publisherdate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (Bid != other.Bid)
			return false;
		if (Bname == null) {
			if (other.Bname != null)
				return false;
		} else if (!Bname.equals(other.Bname))
			return false;
		if (publisherdate == null) {
			if (other.publisherdate != null)
				return false;
		} else if (!publisherdate.equals(other.publisherdate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[Bid=" + Bid + ", Bname=" + Bname + ", publisherdate=" + publisherdate+"]";
	}
	
	
	

}
