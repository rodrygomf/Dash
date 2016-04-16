package nx.kernnel.dash.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import nx.kernnel.dash.R;

/**
 * Created by Rodrigo Figueiredo on 14/04/2016.
 */
public class Tipo implements Serializable {
    private Integer id;
    private String nome;
    private int imagem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public List<Tipo> getLista() {
        List<Tipo> lista = new ArrayList<>();

        Tipo tipo = new Tipo();
        tipo.setId(1);
        tipo.setNome("Alimentação");
        tipo.setImagem(R.drawable.ic_local_dining_black_24dp);
        lista.add(tipo);

        tipo = new Tipo();
        tipo.setId(2);
        tipo.setNome("Parque");
        tipo.setImagem(R.drawable.ic_nature_people_black_24dp);
        lista.add(tipo);

        tipo = new Tipo();
        tipo.setId(3);
        tipo.setNome("Loja");
        tipo.setImagem(R.drawable.ic_shopping_basket_black_24dp);
        lista.add(tipo);

        tipo = new Tipo();
        tipo.setId(4);
        tipo.setNome("Empresa");
        tipo.setImagem(R.drawable.ic_location_city_black_24dp);
        lista.add(tipo);

        return lista;
    }

    public Tipo getTipo(Integer id) {
        return id > 0 && id <= getLista().size() ? getLista().get(id - 1) : getLista().get(0);
    }
}
