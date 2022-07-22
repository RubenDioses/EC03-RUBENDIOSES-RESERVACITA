package com.idat.EC3RUBENDIOSESreservacita.service;

import java.util.List;

import com.idat.EC3RUBENDIOSESreservacita.dto.UsuarioClienteDTORequest;
import com.idat.EC3RUBENDIOSESreservacita.dto.UsuarioClienteDTOResponse;


public interface UsuarioClienteService {
	
	public void guardarUsuarioCliente (UsuarioClienteDTORequest usuariocliente);
	public void editarUsuarioCliente(UsuarioClienteDTORequest usuariocliente);
	
	public void eliminarUsuarioCliente(Integer id);
	
	public List<UsuarioClienteDTOResponse> listarUsuarioCliente();
	public UsuarioClienteDTOResponse obtenerUsuarioClienteId(Integer id);	

}
