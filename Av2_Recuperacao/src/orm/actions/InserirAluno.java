package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class InserirAluno {
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

        System.out.println("Digite a data de nascimento do aluno (formato: dd-MM-yyyy):");
        String dataNascimento = scanner.nextLine();

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

        em.close();
        emf.close();
        scanner.close();
    }
}
