package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class DeletarAluno {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaPU");
        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);

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
        scanner.close();
    }
}

