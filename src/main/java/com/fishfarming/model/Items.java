package com.fishfarming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Items {

	@Transient
	private String categoryId;
	@Transient
	private String subCategoryId;
	@Id
	@Column
	private String itemId;
	@Column
	private String itemName;
	@Column
	private String imageUrl;
	@Column
	private float price;
	@Column
	private String description;
	@Column
	private String quantity;


}
