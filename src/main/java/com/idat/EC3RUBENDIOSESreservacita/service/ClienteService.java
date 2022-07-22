package com.idat.EC3RUBENDIOSESreservacita.service;

import java.util.List;

import com.idat.EC3RUBENDIOSESreservacita.model.Cliente;

public interface ClienteService {
	
	public void guardarCliente (Cliente cliente);
	public void editarCliente(Cliente cliente);
	public void eliminarCliente(Integer id);
	public List<Cliente> listarCliente();
	public Cliente obtenerClienteId(Integer id);	

}
