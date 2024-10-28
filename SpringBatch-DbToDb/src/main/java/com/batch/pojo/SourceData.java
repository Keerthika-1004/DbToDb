package com.batch.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="source")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceData {

	@Id
	private int id;
	private String name;
}
