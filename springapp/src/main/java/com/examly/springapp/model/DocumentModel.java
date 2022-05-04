package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Setter
@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name = "Documents")
public class DocumentModel {

	@Id
	@Column(name = "documentId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int documentId;

	private String fileName;

	private String documentType;

	@Lob
	private byte[] document;

	public DocumentModel(String fileName, String documentType, byte[] document) {
		super();
		this.fileName = fileName;
		this.documentType = documentType;
		this.document = document;
	}

}