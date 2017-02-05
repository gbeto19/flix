package services;

import Entidades.Filme;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

@SessionScoped
@ManagedBean
public class FilmeService {

    private Filme filmebean = new Filme();
    private List<Filme> listaFilmes = new ArrayList<>();

    
    public FilmeService() {
        listarFilmes();
    }

    // METODO SALVAR FILME
    public String salvarFilme() {
        Session sessaoSalva = HibernateUtil.getSessionFactory().openSession();
        Transaction trasaSalva = sessaoSalva.getTransaction();

        try {
            trasaSalva.begin();
            sessaoSalva.save(getFilmebean());
            trasaSalva.commit();

        } catch (Exception e) {
        } finally {
            sessaoSalva.close();
            
        }
            return "Consulta";
    }
    // METODO LISTAR FILMES

    public void listarFilmes() {
        Session sessaoLista = HibernateUtil.getSessionFactory().openSession();
        listaFilmes = sessaoLista.createCriteria(Filme.class).list();
    }

    // METODO EXCLUIR FILMES
    public void excluirFilmes(Filme f) {
        Session sesExcluir = HibernateUtil.getSessionFactory().openSession();
        Transaction transaExcluir = sesExcluir.getTransaction();

        try {
            transaExcluir.begin();
            sesExcluir.delete(f);
            transaExcluir.commit();
        } catch (Exception e) {
        } finally {
            sesExcluir.close();
            listarFilmes();
        }
    }

    // CAPTURAR FILME
    public String capturarFilme(Filme f) {
        setFilmebean(f);
        return "formfilme";

    }

    // METODO ATUALIZAR FILMES
    public String atualizarFilme() {
        Session sesAutaliza = HibernateUtil.getSessionFactory().openSession();
        Transaction tranAtualiza = sesAutaliza.getTransaction();

        try {
            tranAtualiza.begin();
            sesAutaliza.update(filmebean);
            tranAtualiza.commit();
            setFilmebean(new Filme());
            
        } catch (Exception e) {
        } finally {
            
            sesAutaliza.close();
           
        }
       
            return "Consulta";
    }

    // GET AND SET
    public Filme getFilmebean() {
        return filmebean;
    }

    public void setFilmebean(Filme filmebean) {
        this.filmebean = filmebean;
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

}
