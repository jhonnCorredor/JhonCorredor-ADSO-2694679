package com.sena.servicesecurity.DTO;

import java.util.List;

public interface IModuleDto extends IGenericDto{


    String getModule();
    String getDescription();
 
    Long getId();
    Boolean getState();
    
    String getViewName();
    String getViewRoute();
    List<IViewDto> getViews();
    void setViews(List<IViewDto> views);
}
