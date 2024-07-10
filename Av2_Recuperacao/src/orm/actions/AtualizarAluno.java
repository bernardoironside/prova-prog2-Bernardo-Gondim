package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AtualizarAluno {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaPU");
        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do aluno que deseja alterar:");
        Long idAlterar = scanner.nextLong();
        scanner.nextLine();

        Aluno alunoAlterar = em.find(Aluno.class, idAlterar);

        if (alunoAlterar != null) {
            System.out.println("Digite o novo nome:");
            String novoNome = scanner.nextLine();
            alunoAlterar.setNome(novoNome);

            System.out.println("Digite o novo email:");
            String novoEmail = scanner.nextLine();
            alunoAlterar.setEmail(novoEmail);

            System.out.println("Digite o novo cpf:");
            String novoCpf = scanner.nextLine();
            alunoAlterar.setCpf(novoCpf);

            System.out.println("Digite o novo data de Nascimento:");
            String novoDataNascimento = scanner.nextLine();
            alunoAlterar.setDataNascimento(novoDataNascimento);

            System.out.println("Digite o novo naturalidade:");
            String novoNaturalidade = scanner.nextLine();
            alunoAlterar.setNaturalidade(novoNaturalidade);

            System.out.println("Digite o novo endereço:");
            String novoEndereco = scanner.nextLine();
            alunoAlterar.setEndereco(novoEndereco);

            em.getTransaction().begin();
            em.merge(alunoAlterar);
            em.getTransaction().commit();
        } else {
            System.out.println("Aluno não encontrado com o ID informado.");
        }
        em.close();
        emf.close();
        scanner.close();
    }
}
