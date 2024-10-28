package com.batch.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="target")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetData {

	@Id
	private int id;
	private String name;
}
