package com.fishfarming.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table
public class ItemCategory {

	@Column
	@Id
	private String categoryId;
	@Column
	private String categoryName;
	@Column
	private String categoryImageUrl;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId")
	@Fetch(FetchMode.JOIN)
	private List<ItemSubCategory> subCategories;

}
