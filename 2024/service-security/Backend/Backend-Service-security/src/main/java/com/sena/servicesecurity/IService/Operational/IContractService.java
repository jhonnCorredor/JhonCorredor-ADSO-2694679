package com.sena.servicesecurity.IService.Operational;

import java.util.List;

import com.sena.servicesecurity.DTO.IContractDto;
import com.sena.servicesecurity.Entity.Operational.Contract;
import com.sena.servicesecurity.IService.IBaseService;

public interface IContractService extends IBaseService<Contract>{

	List<IContractDto> GetListContract();
}
