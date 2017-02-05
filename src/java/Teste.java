
import Entidades.Filme;
import java.math.BigDecimal;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class Teste {
    
    public static void main(String[] args) {
        
        Filme filmeTeste = new Filme();
        filmeTeste.setTitulo("Blade Hunner");
        filmeTeste.setGenero("ficção");
        filmeTeste.setAno("1981");
        filmeTeste.setValor(new BigDecimal (2.00));
        
        
        Session sessaoBanco = HibernateUtil.getSessionFactory().openSession();
        Transaction transacaoBanco = sessaoBanco.getTransaction();
        
        transacaoBanco.begin();
        sessaoBanco.save(filmeTeste);
        transacaoBanco.commit();
        sessaoBanco.close();
        
        /**
         System.out.println("Nome do filme: "+filmeTeste.getTitulo());
        System.out.println("genero: "+filmeTeste.getGenero());
        System.out.println("ano: "+filmeTeste.getGenero());
        System.out.println("Preço: "+filmeTeste.getValor());
        */
        
        
    }
 
    
}
