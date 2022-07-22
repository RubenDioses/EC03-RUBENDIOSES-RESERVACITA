package com.idat.EC3RUBENDIOSESreservacita.repository;

import java.util.List;

import com.idat.EC3RUBENDIOSESreservacita.model.Cliente;

public interface ClienteRepository {
	
	public void guardarCliente (Cliente cliente);
	public void editarCliente(Cliente cliente);
	public void eliminarCliente(Integer id);
	public List<Cliente> listarCliente();
	public Cliente obtenerClienteId(Integer id);	

}
