package com.mongodb.search.collection;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Posts {
	private String profile;
	private String exp;
	private String description;
	private String skills[];
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
		
	}
	public Posts(String profile, String exp, String description, String[] skills) {
		super();
		this.profile = profile;
		this.exp = exp;
		this.description = description;
		this.skills = skills;
	}
	
	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Joblist [profile=" + profile + ", exp=" + exp + ", description=" + description + ", skills="
				+ Arrays.toString(skills) + "]";
	}
	
	

}
