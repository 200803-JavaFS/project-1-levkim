package com.revature.models;

import java.sql.Timestamp;

public class ReimbDTO {

	public int id;
	public double amt;
	public Timestamp submitted;
	public Timestamp resolved;
	public String description;
	public String receipt;
	public String author;
	public String resolver;
	public ReimbStatus status;
	public ReimbType type;
	
	public ReimbDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReimbDTO(double amt, Timestamp submitted, String author, ReimbStatus status, ReimbType type) {
		super();
		this.amt = amt;
		this.submitted = submitted;
		this.author = author;
		this.status = status;
		this.type = type;
	}

	public ReimbDTO(double amt, Timestamp submitted, Timestamp resolved, String description, String receipt,
			String author, String resolver, ReimbStatus status, ReimbType type) {
		super();
		this.amt = amt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public ReimbDTO(int id, double amt, Timestamp submitted, Timestamp resolved, String description, String receipt,
			String author, String resolver, ReimbStatus status, ReimbType type) {
		super();
		this.id = id;
		this.amt = amt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ReimbDTO other = (ReimbDTO) obj;
		if (Double.doubleToLongBits(amt) != Double.doubleToLongBits(other.amt))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbDTO [id=" + id + ", amt=" + amt + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resolver="
				+ resolver + ", status=" + status + ", type=" + type + "]";
	}
	
}
