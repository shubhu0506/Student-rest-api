package com.students.info.entity;
//One-One -Mapping
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "story")
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int storyId;
	@Column(name = "story_name")
	private String storyName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	@JsonBackReference
	private Book book;

}