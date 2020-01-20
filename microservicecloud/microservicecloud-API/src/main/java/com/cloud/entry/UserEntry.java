package com.cloud.entry;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserEntry implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long deptno;
	private String dname;
	private String db_source;
	
}
	