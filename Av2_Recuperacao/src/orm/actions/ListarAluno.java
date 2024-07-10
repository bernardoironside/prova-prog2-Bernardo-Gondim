package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ListarAluno {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EscolaPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Aluno> queryTodos = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
        List<Aluno> todosAlunos = queryTodos.getResultList();

        System.out.println("Lista de todos os alunos:");
        for (Aluno a : todosAlunos) {
            System.out.println("ID: " + a.getId() + ", Nome: " + a.getNome() + ", Email: " + a.getEmail() +
                    ", CPF: " + a.getCpf() + ", Data de Nascimento: " + a.getDataNascimento() +
                    ", Naturalidade: " + a.getNaturalidade() + ", Endereço: " + a.getEndereco());
        }

        em.close();
        emf.close();
    }
}
