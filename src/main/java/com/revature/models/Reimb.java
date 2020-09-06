package com.revature.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="ers_reimbursement")
public class Reimb {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_id", nullable=false)
	private int id;
	
	@Column(name="reimb_amount", nullable=false)
	private double amt;
	
	@CreationTimestamp
	@Column(name="reimb_submitted", nullable=false)
	private LocalDateTime submitted;
	
	@UpdateTimestamp
	@Column(name="reimb_resolved")
	private LocalDateTime resolved;
	
	@Column(name="reimb_description")
	private String description;
	
	@Column(name="reimb_receipt")
	private byte[] receipt;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_author", referencedColumnName="ers_users_id", nullable=false)
	private User author;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_resolver", referencedColumnName="ers_users_id")
	private User resolver;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_status_id_fk", referencedColumnName="reimb_status_id", nullable=false)
	private ReimbStatus status;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_type_id_fk", referencedColumnName="reimb_type_id", nullable=false)
	private ReimbType type;
	
	public Reimb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimb(double amt, LocalDateTime submitted, LocalDateTime resolved, User author, User resolver,
			ReimbStatus status, ReimbType type) {
		super();
		this.amt = amt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public Reimb(double amt, LocalDateTime submitted, LocalDateTime resolved, String description, byte[] receipt,
			User author, User resolver, ReimbStatus status, ReimbType type) {
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

	public Reimb(int id, double amt, LocalDateTime submitted, LocalDateTime resolved, String description,
			byte[] receipt, User author, User resolver, ReimbStatus status, ReimbType type) {
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

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public LocalDateTime getSubmitted() {
		return submitted;
	}
	
	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}
	
	public LocalDateTime getResolved() {
		return resolved;
	}
	
	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}

	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
	
	public User getResolver() {
		return resolver;
	}
	
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	
	public ReimbStatus getStatus() {
		return status;
	}
	
	public void setStatus(ReimbStatus status) {
		this.status = status;
	}
	
	public ReimbType getType() {
		return type;
	}
	
	public void setType(ReimbType type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Reimb other = (Reimb) obj;
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
		if (status != other.status)
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Reimbursement #" + id + "\n"
				+ "   Submitted On: " + submitted + "\n"
			    + "   Resolved On: " + resolved + "\n"
			    + "   Description: " + description + "\n"
			    + "   Receipt: " + receipt + "\n"
			    + "   Author: " + author.getFirst_name() + " " + author.getLast_name() + "\n"
			    + "   Resolver: " + resolver + "\n"
			    + "   Status: " + status.getStatus() + "\n"
			    + "   Type: " + type.getType();
	}

}
