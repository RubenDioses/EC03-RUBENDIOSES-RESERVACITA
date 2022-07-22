package com.idat.EC3RUBENDIOSESreservacita.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC3RUBENDIOSESreservacita.dto.UsuarioClienteDTORequest;
import com.idat.EC3RUBENDIOSESreservacita.dto.UsuarioClienteDTOResponse;
import com.idat.EC3RUBENDIOSESreservacita.model.UsuarioCliente;
import com.idat.EC3RUBENDIOSESreservacita.repository.UsuarioClienteRepository;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService {
	
	@Autowired
	public UsuarioClienteRepository repositorio2;

	@Override
	public void guardarUsuarioCliente(UsuarioClienteDTORequest usuariocliente) {
		
		UsuarioCliente uc = new UsuarioCliente();
		uc.setIdUsuario(usuariocliente.getIdUsuarioDTO());
		uc.setUsuario(usuariocliente.getUsuarioDTO());
		uc.setPassword(usuariocliente.getPasswordDTO());
		uc.setRol(usuariocliente.getRolDTO());
		
		repositorio2.save(uc);

	}

	@Override
	public void editarUsuarioCliente(UsuarioClienteDTORequest usuariocliente) {
		
		UsuarioCliente uc = new UsuarioCliente();
		uc.setIdUsuario(usuariocliente.getIdUsuarioDTO());
		uc.setUsuario(usuariocliente.getUsuarioDTO());
		uc.setPassword(usuariocliente.getPasswordDTO());
		uc.setRol(usuariocliente.getRolDTO());
		
		repositorio2.saveAndFlush(uc);

	}

	@Override
	public void eliminarUsuarioCliente(Integer id) {
		repositorio2.deleteById(id);
	}

	@Override
	public List<UsuarioClienteDTOResponse> listarUsuarioCliente() {
		List<UsuarioClienteDTOResponse> lista = new ArrayList<UsuarioClienteDTOResponse>();
		UsuarioClienteDTOResponse uc = null;
		
		for (UsuarioCliente usuariocliente : repositorio2.findAll()) {
			uc = new UsuarioClienteDTOResponse();
			
			uc.setIdUsuarioDTO(usuariocliente.getIdUsuario());
			uc.setUsuarioDTO(usuariocliente.getUsuario());
			uc.setPasswordDTO(usuariocliente.getPassword());
			uc.setRolDTO(usuariocliente.getRol());
			
			 lista.add(uc);			 
		}
		return lista;
	}

	@Override
	public UsuarioClienteDTOResponse obtenerUsuarioClienteId(Integer id) {
		
		UsuarioCliente usuariocliente = repositorio2.findById(id).orElse(null);
		
		UsuarioClienteDTOResponse uc = new UsuarioClienteDTOResponse();
		
		uc.setIdUsuarioDTO(usuariocliente.getIdUsuario());
		uc.setUsuarioDTO(usuariocliente.getUsuario());
		uc.setPasswordDTO(usuariocliente.getPassword());
		uc.setRolDTO(usuariocliente.getRol());
		
		return uc;

	}

}
