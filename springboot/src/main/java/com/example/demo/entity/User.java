package com.example.demo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;



//使用JPA
@Entity
@Table(name = "User")  //會自動在資料庫建立一個User的資料表
public class User {
	@Id  //指定為主健
	@GeneratedValue(strategy=GenerationType.AUTO)  //設定自動編號
	private Long id;
	
	@Column(name="name",length=50,nullable=false)
	private String name;
	
	@Column  //使用預設
	@NotEmpty(message = "{user.password.empty}")
	private String password;
	
	@Column  //TemporatlType設為DATE只會存日期不會存時間唷
	@Temporal(TemporalType.DATE)  //TemporalType.DATE、TemporalType.TIME、TemporalType.TIMESTAMP
	@NotNull(message = "{user.birth.null}")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	
	@Column  //使用預設
	@NotNull(message = "{user.height.null}")
	@Range(min=30,max=300,message="{user.height.range}")
	private Integer height;
	
	@Column  //使用預設
	@NotNull(message ="{user.weight.null}")
	@Range(min=1,max=300,message="{user.weight.range}")
	private Integer weight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", birth=" + birth + ", height="
				+ height + ", weight=" + weight + "]";
	}

}
