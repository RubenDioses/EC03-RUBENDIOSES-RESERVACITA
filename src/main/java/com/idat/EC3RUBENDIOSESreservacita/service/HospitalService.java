package com.idat.EC3RUBENDIOSESreservacita.service;

import java.util.List;

import com.idat.EC3RUBENDIOSESreservacita.dto.HospitalDTORequest;
import com.idat.EC3RUBENDIOSESreservacita.dto.HospitalDTOResponse;

public interface HospitalService {
	
	public void guardarHospital (HospitalDTORequest hospital);
	public void editarHospital(HospitalDTORequest hospital);
	
	public void eliminarHospital(Integer id);
	
	public List<HospitalDTOResponse> listarHospital();
	public HospitalDTOResponse obtenerHospitalId(Integer id);	

}
