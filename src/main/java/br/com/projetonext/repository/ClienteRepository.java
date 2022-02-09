package br.com.projetonext.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projetonext.bean.Cliente;
import br.com.projetonext.dto.ClienteDTO;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Cliente findByIdCliente(Integer idCliente);
	
	@Query("Select c from Cliente c where c.cpf = ?1 and c.senha = ?2")
	Cliente findByCpfAndSenha(@Param("cpf") String cpf, @Param("senha") String senha);
	
	@Query("Select c from Cliente c where c.nome = ?1")
	Cliente findByNome(@Param("nome") String nome);
}
