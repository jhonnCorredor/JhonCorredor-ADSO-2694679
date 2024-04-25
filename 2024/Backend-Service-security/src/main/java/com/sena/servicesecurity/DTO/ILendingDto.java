package com.sena.servicesecurity.DTO;

import java.time.LocalDateTime;

public interface ILendingDto extends IGenericDto{

	String getBook();
	String getEmployed();
	String getClient();
	int getAmount();
	Boolean getAction();
	LocalDateTime getDate();
}
