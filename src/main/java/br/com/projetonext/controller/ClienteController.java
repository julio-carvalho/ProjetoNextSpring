package br.com.projetonext.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.projetonext.bean.Cliente;
import br.com.projetonext.bo.ClienteBO;
import br.com.projetonext.dto.ClienteDTO;
import br.com.projetonext.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	private ClienteDTO cliDTO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(Model model) {
		ClienteDTO cliDTO = new ClienteDTO();
		model.addAttribute("clienteDTO", cliDTO);
		return "index";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String getCadastro(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String insertCliente(Cliente cliente) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			cliente.setData(sdf.parse(cliente.getDataString()));
		} catch (ParseException e) {}
		
		ClienteBO cliBO = this.getClienteBO();
		cliBO.inserirCliente(cliente);
		
		return "redirect:/?inseriu=true";
	}
	
	
	public ClienteBO getClienteBO() {
		return new ClienteBO(this.clienteRepo);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ClienteDTO clienteDTO) {
		Cliente cli = clienteRepo.findByCpfAndSenha(clienteDTO.getCpf(), clienteDTO.getSenha());
		
		if(cli == null) {
			return "redirect:/?logininvalido";
		}
		
		clienteDTO.setNome(cli.getNome());
		cliDTO = clienteDTO;
		
		return "home";
	}
	
	@RequestMapping(value = "/extrato", method = RequestMethod.GET)
	public String getExtrato() {
		return "extrato";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome() {
		return "home";
	}
}
