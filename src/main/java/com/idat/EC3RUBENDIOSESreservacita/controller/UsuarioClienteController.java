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

import com.idat.EC3RUBENDIOSESreservacita.dto.UsuarioClienteDTORequest;
import com.idat.EC3RUBENDIOSESreservacita.dto.UsuarioClienteDTOResponse;
import com.idat.EC3RUBENDIOSESreservacita.model.UsuarioCliente;
import com.idat.EC3RUBENDIOSESreservacita.service.UsuarioClienteService;



@RestController
@RequestMapping("/usuariocliente/uc1")
public class UsuarioClienteController {
	
	@Autowired
	private UsuarioClienteService servicio3;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioClienteDTOResponse>> listarUsuarioCliente(){
		
		return new ResponseEntity<List<UsuarioClienteDTOResponse>>(servicio3.listarUsuarioCliente(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioCliente usuariocliente){
		
		servicio3.guardarUsuarioCliente(null);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<UsuarioClienteDTOResponse> listarPorId(@PathVariable Integer id) {
		
		UsuarioClienteDTOResponse uc = servicio3.obtenerUsuarioClienteId(id);
		if(uc != null)
			return new ResponseEntity<UsuarioClienteDTOResponse>(uc, HttpStatus.OK);
		
		return new ResponseEntity<UsuarioClienteDTOResponse>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping (path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody UsuarioClienteDTORequest usuariocliente){
		
		UsuarioClienteDTOResponse uc = servicio3.obtenerUsuarioClienteId(usuariocliente.getIdUsuarioDTO());
		
		if(uc != null) {
			servicio3.editarUsuarioCliente(usuariocliente);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UsuarioClienteDTOResponse uc = servicio3.obtenerUsuarioClienteId(id);
		if(uc != null) {
			servicio3.eliminarUsuarioCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
		
	}

}
