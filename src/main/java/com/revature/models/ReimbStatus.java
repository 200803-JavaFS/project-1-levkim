package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="ers_reimbursement_status")
public class ReimbStatus {
	
	@Column(name="reimb_status_id")
	private int id;
	
	@Column(name="reimb_status")
	@Enumerated(EnumType.STRING)
	private RStatus status;

	public ReimbStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReimbStatus(int id, RStatus status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RStatus getStatus() {
		return status;
	}

	public void setStatus(RStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ReimbStatus other = (ReimbStatus) obj;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbStatus [id=" + id + ", status=" + status + "]";
	}

}
