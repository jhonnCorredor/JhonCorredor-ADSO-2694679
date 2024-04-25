package com.sena.servicesecurity.Service.Parameter;

import org.springframework.stereotype.Service;

import com.sena.servicesecurity.IService.Parameter.IEnumService;
import com.sena.servicesecurity.Utils.Days;
import com.sena.servicesecurity.Utils.Months;
import com.sena.servicesecurity.Utils.Nomenclature;
import com.sena.servicesecurity.Utils.TypeDocument;

@Service
public class EnumService implements IEnumService{

	@Override
	public Nomenclature[] getDirections() {
		return Nomenclature.values();
	}

	@Override
	public Days[] getDias() {
		return Days.values();
	}

	@Override
	public Months[] getMeses() {
		return Months.values();
	}

	@Override
	public TypeDocument[] getTdocuments() {
		return TypeDocument.values();
	}

}
