package com.idat.EC3RUBENDIOSESreservacita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.EC3RUBENDIOSESreservacita.model.UsuarioCliente;

@Repository
public interface UsuarioClienteRepository  extends JpaRepository<UsuarioCliente, Integer>{

}