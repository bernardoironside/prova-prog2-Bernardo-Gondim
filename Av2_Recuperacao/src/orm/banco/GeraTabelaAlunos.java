package orm.banco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelaAlunos {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EscolaPU");
        factory.close();
    }
}