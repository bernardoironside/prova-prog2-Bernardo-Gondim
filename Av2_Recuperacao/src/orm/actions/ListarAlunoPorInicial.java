package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class ListarAlunoPorInicial {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaPU");
        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);

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

        em.close();
        emf.close();
        scanner.close();

    }
}
