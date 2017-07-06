package com.algaworks.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import com.algaworks.cobranca.repository.filter.TituloFilter;

@Service
public class CadastroTituloService {

	@Autowired
	private Titulos titulos;
	
	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de fecha inválido");
		}
	}

	public void excluir(Long id) {
		titulos.delete(id);
	}

	public String recibir(Long id) {
		Titulo titulo = titulos.findOne(id);
		titulo.setStatus(StatusTitulo.RECIBIDO);
		titulos.save(titulo);
		
		return StatusTitulo.RECIBIDO.getDescripcion();
		
	}
	
	
	public List<Titulo>filtrar(TituloFilter filtro){
		String descripcion = filtro.getDescripcion() == null ? "%" : filtro.getDescripcion();
		return  titulos.findByDescripcionContaining(descripcion);
	}
	
}









