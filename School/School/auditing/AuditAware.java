package com.auditing;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditAware<K> {
	@CreatedBy
	protected K createdBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date creactionDate;

	@LastModifiedBy
	protected K lastModifiedBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedDate;

	public K getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(K createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreactionDate() {
		return creactionDate;
	}

	public void setCreactionDate(Date creactionDate) {
		this.creactionDate = creactionDate;
	}

	public K getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(K lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "AuditAware [createdBy=" + createdBy + ", creactionDate=" + creactionDate + ", lastModifiedBy="
				+ lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
