package com.idat.EC3RUBENDIOSESreservacita.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.idat.EC3RUBENDIOSESreservacita.dto.HospitalDTORequest;
import com.idat.EC3RUBENDIOSESreservacita.dto.HospitalDTOResponse;
import com.idat.EC3RUBENDIOSESreservacita.model.Hospital;
import com.idat.EC3RUBENDIOSESreservacita.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	public HospitalRepository repositorio1;

	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		
		Hospital h = new Hospital();
		h.setIdHospital(hospital.getIdHospitalDTO());
		h.setNombre(hospital.getNombreDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		
		repositorio1.save(h);
	}

	@Override
	public void editarHospital(HospitalDTORequest hospital) {
		Hospital h = new Hospital();
		h.setIdHospital(hospital.getIdHospitalDTO());
		h.setNombre(hospital.getNombreDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		
		repositorio1.saveAndFlush(h);

	}

	@Override
	public void eliminarHospital(Integer id) {
		repositorio1.deleteById(id);
	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		List<HospitalDTOResponse> lista = new ArrayList<HospitalDTOResponse>();
		HospitalDTOResponse h = null;
		
		
		for (Hospital hospital : repositorio1.findAll()) {
			h = new HospitalDTOResponse();
			
			h.setIdHospitalDTO(hospital.getIdHospital());
			h.setNombreDTO(hospital.getNombre());
			h.setDescripcionDTO(hospital.getDescripcion());
			h.setDistritoDTO(hospital.getDistrito());
			
			lista.add(h);
		}
		return lista;
		
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		Hospital hospital = repositorio1.findById(id).orElse(null);
		HospitalDTOResponse h = new HospitalDTOResponse();
		
		h.setIdHospitalDTO(hospital.getIdHospital());
		h.setNombreDTO(hospital.getNombre());
		h.setDescripcionDTO(hospital.getDescripcion());
		h.setDistritoDTO(hospital.getDistrito());
		
		return h;
	}

}
