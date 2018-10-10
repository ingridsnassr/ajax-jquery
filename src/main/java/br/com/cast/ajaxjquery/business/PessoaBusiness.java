package br.com.cast.ajaxjquery.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.ajaxjquery.dto.PessoaDTO;
import br.com.cast.ajaxjquery.entidade.Endereco;
import br.com.cast.ajaxjquery.entidade.Pessoa;
import br.com.cast.ajaxjquery.persistencia.PessoaDAO;

public class PessoaBusiness {
	private PessoaDAO pessoaDAO;
	public PessoaBusiness() {
		this.pessoaDAO = new PessoaDAO();
	}
	
	public List<PessoaDTO> buscarTodas() {
		//TODO chamar o DAO para pesquisar
		List<PessoaDTO> dtos = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			PessoaDTO dto = new PessoaDTO();
			
			dto.setCpf("111 " + i);
			dto.setNome("Sysout " + i);
			dto.setEmail("sysout@gmail." + i);
			
			dtos.add(dto);
		}
		
		return dtos;
	}

	public void salvar(PessoaDTO pessoaDTO)  {
		//converter de dto para entidade
				Pessoa pessoa = new Pessoa();
				Endereco endereco = new Endereco();
				
				pessoa.setCpf(pessoaDTO.getCpf());
				pessoa.setEmail(pessoaDTO.getEmail());
				pessoa.setNome(pessoaDTO.getNome());
				
				String cepEnt = pessoaDTO.getEnderecoDTO().getCep();
				
				endereco.setCep(cepEnt);
				endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getLogradouro());
				endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getBairro());
				endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getCidade());
				endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getComplemento());
				endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getNumero());
				endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getUf());
				
				
				pessoa.setEndereco(endereco);
				
				pessoaDAO.inserir(pessoa);
				
				System.out.println(endereco);
	}			

}
