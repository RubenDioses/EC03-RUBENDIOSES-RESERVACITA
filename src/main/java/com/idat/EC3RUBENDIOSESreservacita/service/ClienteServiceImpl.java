package com.idat.EC3RUBENDIOSESreservacita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC3RUBENDIOSESreservacita.model.Cliente;
import com.idat.EC3RUBENDIOSESreservacita.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	public ClienteRepository repositorio;

	@Override
	public void guardarCliente(Cliente cliente) {
		repositorio.guardarCliente(cliente);
	}

	@Override
	public void editarCliente(Cliente cliente) {
		repositorio.editarCliente(cliente);

	}

	@Override
	public void eliminarCliente(Integer id) {
		repositorio.eliminarCliente(id);

	}

	@Override
	public List<Cliente> listarCliente() {
		return repositorio.listarCliente();
	}

	@Override
	public Cliente obtenerClienteId(Integer id) {
		return repositorio.obtenerClienteId(id);
	}

}
