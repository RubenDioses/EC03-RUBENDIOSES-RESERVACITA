package com.idat.EC3RUBENDIOSESreservacita.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.EC3RUBENDIOSESreservacita.model.Cliente;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
	
	public List<Cliente> listar = new ArrayList<Cliente>();

	@Override
	public void guardarCliente(Cliente cliente) {
		listar.add(cliente);

	}

	@Override
	public void editarCliente(Cliente cliente) {
		listar.remove(cliente.getIdCliente());
		listar.remove(obtenerClienteId(cliente.getIdCliente()));
		listar.add(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		listar.remove(obtenerClienteId(id));

	}

	@Override
	public List<Cliente> listarCliente() {		
		return listar;
	}

	@Override
	public Cliente obtenerClienteId(Integer id) {
//		if(id != null) {
//			for (Cliente cliente : listar) {			
//				if(cliente.getIdCliente() == id)
//					return cliente;
//				else
//					return null;
//				}
//			}else {
//				return null;
//		}
		return listar.stream().filter(cliente -> cliente.getIdCliente() == id).findFirst().orElse(null);
	}
		

}
