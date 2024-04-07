package com.sena.servicesecurity.IService.Parameter;

import com.sena.servicesecurity.Utils.Days;
import com.sena.servicesecurity.Utils.Months;
import com.sena.servicesecurity.Utils.Nomenclature;
import com.sena.servicesecurity.Utils.TypeDocument;

public interface IEnumService {

	Nomenclature[] getDirections();
	Days[] getDias();
	Months[] getMeses();
	TypeDocument[] getTdocuments();
}
