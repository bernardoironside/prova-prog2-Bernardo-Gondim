package com.example.school;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Aluno {

   
  

 
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaPU");
        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do aluno:");
        String email = scanner.nextLine();

        System.out.println("Digite o CPF do aluno:");
        String cpf = scanner.nextLine();

        System.out.println("Digite a data de nascimento do aluno (formato: yyyy-MM-dd):");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        System.out.println("Digite a naturalidade do aluno:");
        String naturalidade = scanner.nextLine();

        System.out.println("Digite o endereço do aluno:");
        String endereco = scanner.nextLine();

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setCpf(cpf);
        aluno.setDataNascimento(dataNascimento);
        aluno.setNaturalidade(naturalidade);
        aluno.setEndereco(endereco);

        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();

        
        TypedQuery<Aluno> queryTodos = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
        List<Aluno> todosAlunos = queryTodos.getResultList();

        System.out.println("Lista de todos os alunos:");
        for (Aluno a : todosAlunos) {
            System.out.println("ID: " + a.getId() + ", Nome: " + a.getNome() + ", Email: " + a.getEmail() +
                    ", CPF: " + a.getCpf() + ", Data de Nascimento: " + a.getDataNascimento() +
                    ", Naturalidade: " + a.getNaturalidade() + ", Endereço: " + a.getEndereco());
        }

        System.out.println("Digite a inicial do nome para filtrar os alunos:");
        String inicial = scanner.nextLine();

        TypedQuery<Aluno> queryInicial = em.createQuery("SELECT a FROM Aluno a WHERE LOWER(a.nome) LIKE :inicial", Aluno.class);
        queryInicial.setParameter("inicial", inicial.toLowerCase() + "%");

        List<Aluno> alunosPorInicial = queryInicial.getResultList();

        System.out.println("Alunos com nome iniciado por '" + inicial + "':");
        for (Aluno a : alunosPorInicial) {
            System.out.println("ID: " + a.getId() + ", Nome: " + a.getNome() + ", Email: " + a.getEmail() +
                    ", CPF: " + a.getCpf() + ", Data de Nascimento: " + a.getDataNascimento() +
                    ", Naturalidade: " + a.getNaturalidade() + ", Endereço: " + a.getEndereco());
        }

        
        System.out.println("Digite o ID do aluno que deseja alterar:");
        Long idAlterar = scanner.nextLong();
        

        Aluno alunoAlterar = em.find(Aluno.class, idAlterar);

        if (alunoAlterar != null) {
            System.out.println("Digite o novo nome:");
            String novoNome = scanner.nextLine();
            alunoAlterar.setNome(novoNome);

            System.out.println("Digite o novo email:");
            String novoEmail = scanner.nextLine();
            alunoAlterar.setEmail(novoEmail);

            em.getTransaction().begin();
            em.merge(alunoAlterar);
            em.getTransaction().commit();
        } else {
            System.out.println("Aluno não encontrado com o ID informado.");
        }

        
        System.out.println("Digite o ID do aluno que deseja remover:");
        Long idRemover = scanner.nextLong();

        Aluno alunoRemover = em.find(Aluno.class, idRemover);

        if (alunoRemover != null) {
            em.getTransaction().begin();
            em.remove(alunoRemover);
            em.getTransaction().commit();
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Aluno não encontrado com o ID informado.");
        }

        em.close();
        emf.close();
    }



	private String getCpf() {
		// TODO Auto-generated method stub
		return null;
	}



	private String getNaturalidade() {
		// TODO Auto-generated method stub
		return null;
	}



	private String getEndereco() {
		// TODO Auto-generated method stub
		return null;
	}



	private String getDataNascimento() {
		// TODO Auto-generated method stub
		return null;
	}



	private String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}



	private String getNome() {
		// TODO Auto-generated method stub
		return null;
	}



	private String getId() {
		// TODO Auto-generated method stub
		return null;
	}



	private void setEndereco(String endereco2) {
		// TODO Auto-generated method stub
		
	}



	private void setNaturalidade(String naturalidade2) {
		// TODO Auto-generated method stub
		
	}



	private void setDataNascimento(LocalDate dataNascimento2) {
		// TODO Auto-generated method stub
		
	}



	private void setCpf(String cpf2) {
		// TODO Auto-generated method stub
		
	}



	private void setEmail(String email2) {
		// TODO Auto-generated method stub
		
	}



	private void setNome(String nome2) {
		// TODO Auto-generated method stub
		
	}
}
