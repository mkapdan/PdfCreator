package com.kaptan.document.data;

import java.util.HashSet;
import java.util.Set;

/**
 * This class hold metadata properties of pdf document
 * 
 * @author mustafa.kapdan
 *
 */
public class DocumentMetaData {

	protected String title;

	protected String subject;

	protected Set<String> searchKeywords;

	protected String author;

	protected String creator;

	public DocumentMetaData() {
	}

	public DocumentMetaData(String title, String subject, Set<String> searchKeywords, String author, String creator) {
		super();
		this.title = title;
		this.subject = subject;
		this.searchKeywords = searchKeywords;
		this.author = author;
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}

	public DocumentMetaData setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getSubject() {
		return subject;
	}

	public DocumentMetaData setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public Set<String> getSearchKeywords() {
		if (null == searchKeywords) {
			this.searchKeywords = new HashSet<String>();
		}
		return searchKeywords;
	}

	public DocumentMetaData setSearchKeywords(Set<String> searchKeywords) {
		this.searchKeywords = searchKeywords;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public DocumentMetaData setAuthor(String author) {
		this.author = author;
		return this;
	}

	public String getCreator() {
		return creator;
	}

	public DocumentMetaData setCreator(String creator) {
		this.creator = creator;
		return this;
	}

	public String getLinearizedKeys() {
		StringBuilder sb = new StringBuilder();

		for (String key : getSearchKeywords()) {
			sb.append(key);
			sb.append(",");
		}

		return sb.toString();

	}

}
