package org.kidding.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {

	private String userid,userpw,username;
	private boolean enabled;
	private Date regdate, updateDate;

	private List<AuthVO> authList;
	
}
