package com.sena.servicesecurity.DTO;

import java.util.List;

public interface IUserDto extends IGenericDto {

	String getUser();
	String getPersonName();
	String getPersonEmail();
	String getRoute();
	List<IViewDto> getRutas();
	
	void setRutas(List<IViewDto> rutas);
	
}
