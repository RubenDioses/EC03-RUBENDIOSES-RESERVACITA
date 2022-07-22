package com.idat.EC3RUBENDIOSESreservacita.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC3RUBENDIOSESreservacita.dto.ClienteDTORequest;
import com.idat.EC3RUBENDIOSESreservacita.dto.ClienteDTOResponse;
import com.idat.EC3RUBENDIOSESreservacita.model.Cliente;
import com.idat.EC3RUBENDIOSESreservacita.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	public ClienteRepository repositorio;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setNombre(cliente.getNombreDTO());
		c.setCelular(cliente.getCelularDTO());
		
		repositorio.save(c);
	}

	@Override
	public void editarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setNombre(cliente.getNombreDTO());
		c.setCelular(cliente.getCelularDTO());
		
		repositorio.saveAndFlush(c);

	}

	@Override
	public void eliminarCliente(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<ClienteDTOResponse> listarCliente() {
		
		List<ClienteDTOResponse> lista = new ArrayList<ClienteDTOResponse>();
		ClienteDTOResponse c = null;
		
		
		for (Cliente cliente : repositorio.findAll()) {
			c = new ClienteDTOResponse();
			
			c.setIdClienteDTO(cliente.getIdCliente());
			c.setNombreDTO(cliente.getNombre());
			c.setCelularDTO(cliente.getCelular());
			
			lista.add(c);
		}
		return lista;
		
		
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		
		Cliente cliente = repositorio.findById(id).orElse(null);
		
		ClienteDTOResponse c = new ClienteDTOResponse();
		
		c.setIdClienteDTO(cliente.getIdCliente());
		c.setNombreDTO(cliente.getNombre());
		c.setCelularDTO(cliente.getCelular());
		
		return c;
		
		
	}

}
