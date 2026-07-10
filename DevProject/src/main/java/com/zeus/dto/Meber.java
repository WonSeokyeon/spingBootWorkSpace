package com.zeus.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Meber {
	@NotBlank
	@Size(max=3)
	private String userId;
	private String password;
	private String userName;
	private String email;
	private String introduction;
	private LocalDate dateOfBirth;
	private String[] hobbyArray;
	private boolean foreigner;
	private List<CodeLabelValue> hobbyList;
	private List<String> hobbyValue;
	private Map<String, String> hobbyMap;
	private List<String> hobbyList2;

}