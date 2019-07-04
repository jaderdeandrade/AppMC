package com.jda.appmc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jda.appmc.domain.Categoria;
import com.jda.appmc.domain.Cidade;
import com.jda.appmc.domain.Cliente;
import com.jda.appmc.domain.Endereco;
import com.jda.appmc.domain.Estado;
import com.jda.appmc.domain.Produto;
import com.jda.appmc.domain.enums.TipoCliente;
import com.jda.appmc.repositories.CategoriaRepository;
import com.jda.appmc.repositories.CidadeRepository;
import com.jda.appmc.repositories.ClienteRepository;
import com.jda.appmc.repositories.EnderecoRepository;
import com.jda.appmc.repositories.EstadoRepository;
import com.jda.appmc.repositories.ProdutoRepository;



@SpringBootApplication
public class AppmcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;	
	
	@Autowired
	private ClienteRepository clienteRepository;	
	
	@Autowired
	private EnderecoRepository enderecoRepository;		

	public static void main(String[] args) {
		SpringApplication.run(AppmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		
		Produto p1 = new Produto(null, "Computador",2000.00);
		Produto p2 = new Produto(null, "Impressora",800.00);
		Produto p3 = new Produto(null, "Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		

		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
	
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","mariasilva@gmail.com","36925874112",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("3333218144","339999461726"));
		
		Endereco e1 = new Endereco(null, "Rua das Flores","300","Apto 303","Jardim","3820869", cli1,c1);
		Endereco e2 = new Endereco(null, "Avenida Mattos","105","Sala 800","Centro","3820869", cli1,c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
