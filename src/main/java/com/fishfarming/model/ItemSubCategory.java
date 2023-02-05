package com.fishfarming.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Component
@Entity
@Table
public class ItemSubCategory {

	@Transient
	private String categoryId;
	@Id
	@Column
	private String subCategoryId;
	@Column
	private String subCategoryName;
	@Column
	private String subCategoryImageUrl;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "subCategoryId")
	@Fetch(FetchMode.JOIN)
	private List<Items> items;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ItemSubCategory that = (ItemSubCategory) o;
		return subCategoryId.equals(that.subCategoryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subCategoryId);
	}
}
