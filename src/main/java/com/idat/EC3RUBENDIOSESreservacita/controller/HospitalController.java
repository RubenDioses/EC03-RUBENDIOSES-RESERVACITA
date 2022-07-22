package com.idat.EC3RUBENDIOSESreservacita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EC3RUBENDIOSESreservacita.dto.HospitalDTORequest;
import com.idat.EC3RUBENDIOSESreservacita.dto.HospitalDTOResponse;
import com.idat.EC3RUBENDIOSESreservacita.model.Hospital;
import com.idat.EC3RUBENDIOSESreservacita.service.HospitalService;

@RestController
@RequestMapping("/hospital/h1")
public class HospitalController {
	
	@Autowired
	private HospitalService servicio1;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<HospitalDTOResponse>> listarHospital(){
		
		return new ResponseEntity<List<HospitalDTOResponse>>(servicio1.listarHospital(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Hospital hospital){
		
		servicio1.guardarHospital(null);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<HospitalDTOResponse> listarPorId(@PathVariable Integer id) {
		
		HospitalDTOResponse h = servicio1.obtenerHospitalId(id);
		if(h != null)
			return new ResponseEntity<HospitalDTOResponse>(h, HttpStatus.OK);
		
		return new ResponseEntity<HospitalDTOResponse>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping (path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody HospitalDTORequest hospital){
		
		HospitalDTOResponse h = servicio1.obtenerHospitalId(hospital.getIdHospitalDTO());
		
		if(h != null) {
			servicio1.editarHospital(hospital);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		HospitalDTOResponse h = servicio1.obtenerHospitalId(id);
		if(h != null) {
			servicio1.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
		
	}

}
