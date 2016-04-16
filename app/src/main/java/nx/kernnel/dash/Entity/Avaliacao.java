package nx.kernnel.dash.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rodrigo Figueiredo on 14/04/2016.
 */
public class Avaliacao {
    private Integer id;
    private Integer idUsuario;
    private Integer idLocal;
    private Date data;
    private Integer nota;
    private Integer preco;
    private boolean processado;

    private List<Avaliacao> lista;

    public void Avaliacao() {
        createList();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public boolean isProcessado() {
        return processado;
    }

    public void setProcessado(boolean processado) {
        this.processado = processado;
    }

    public List<Avaliacao> getLista() {
        return lista;
    }

    public void setLista(List<Avaliacao> lista) {
        this.lista = lista;
    }

    private void createList() {
        lista = new ArrayList<>();

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(1);
        avaliacao.setIdUsuario(1);
        avaliacao.setIdLocal(1);
        avaliacao.setData(new Date());
        avaliacao.setPreco(3);
        avaliacao.setNota(2);
        avaliacao.setProcessado(true);
        lista.add(avaliacao);

        avaliacao = new Avaliacao();
        avaliacao.setId(2);
        avaliacao.setIdUsuario(1);
        avaliacao.setIdLocal(3);
        avaliacao.setData(new Date());
        avaliacao.setPreco(2);
        avaliacao.setNota(3);
        avaliacao.setProcessado(true);
        lista.add(avaliacao);

        avaliacao = new Avaliacao();
        avaliacao.setId(1);
        avaliacao.setIdUsuario(1);
        avaliacao.setIdLocal(6);
        avaliacao.setData(new Date());
        avaliacao.setPreco(0);
        avaliacao.setNota(2);
        avaliacao.setProcessado(true);
        lista.add(avaliacao);
    }

    public Avaliacao getAvaliacao(Integer id) {
        List<Avaliacao> lista = this.getLista();

        if(id > 0 && id < lista.size()+1) {
            return lista.get(id-1);
        }else{
            return lista.get(0);
        }
    }
}
