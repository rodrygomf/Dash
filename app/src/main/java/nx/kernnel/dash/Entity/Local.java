package nx.kernnel.dash.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rodrigo Figueiredo on 14/04/2016.
 */
public class Local implements Serializable {
    private Integer id;
    private String nome;
    private Tipo tipo;
    private Date data;
    private boolean status;
    private Integer nota;
    private Integer preco;
    private DashLocation dashLocation;

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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public DashLocation getDashLocation() {
        return dashLocation;
    }

    public void setDashLocation(DashLocation dashLocation) {
        this.dashLocation = dashLocation;
    }

    public List<Local> getLista() {
        // Nota: 1 - 5 : Ruim -> Bom
        // Preço: 1 - 3 : Barato -> Caro : 0 Sem Preço/Público
        List<Local> lista = new ArrayList<>();

        Local local = new Local();
        local.setId(1);
        local.setNome("Mercadorama");
        Tipo tipo = new Tipo();
        local.setTipo(tipo.getTipo(3));
        local.setData(new Date());
        local.setStatus(true);
        local.setNota(2);
        local.setPreco(3);
        DashLocation dashLocation = new DashLocation();
        dashLocation.setNome("Mercadorama");
        dashLocation.setLatitude(-25.428442);
        dashLocation.setLongitude(-49.263147);
        local.setDashLocation(dashLocation);
        lista.add(local);

        local = new Local();
        local.setId(2);
        local.setNome("Condor");
        tipo = new Tipo();
        local.setTipo(tipo.getTipo(3));
        local.setData(new Date());
        local.setStatus(true);
        local.setNota(4);
        local.setPreco(2);
        dashLocation = new DashLocation();
        dashLocation.setNome("Condor");
        dashLocation.setLatitude(-25.482572);
        dashLocation.setLongitude(-49.220437);
        local.setDashLocation(dashLocation);
        lista.add(local);

        local = new Local();
        local.setId(3);
        local.setNome("McDonalds");
        tipo = new Tipo();
        local.setTipo(tipo.getTipo(1));
        local.setData(new Date());
        local.setStatus(true);
        local.setNota(3);
        local.setPreco(2);
        dashLocation = new DashLocation();
        dashLocation.setNome("McDonalds");
        dashLocation.setLatitude(-25.430224);
        dashLocation.setLongitude(-49.269539);
        local.setDashLocation(dashLocation);
        lista.add(local);

        local = new Local();
        local.setId(4);
        local.setNome("Madero");
        tipo = new Tipo();
        local.setTipo(tipo.getTipo(1));
        local.setData(new Date());
        local.setStatus(true);
        local.setNota(5);
        local.setPreco(3);
        dashLocation = new DashLocation();
        dashLocation.setNome("Madero");
        dashLocation.setLatitude(-25.427808);
        dashLocation.setLongitude(-49.274269);
        local.setDashLocation(dashLocation);
        lista.add(local);

        local = new Local();
        local.setId(5);
        local.setNome("Passeio Público");
        tipo = new Tipo();
        local.setTipo(tipo.getTipo(2));
        local.setData(new Date());
        local.setStatus(true);
        local.setNota(3);
        local.setPreco(0);
        dashLocation = new DashLocation();
        dashLocation.setNome("Passeio Público");
        dashLocation.setLatitude(-25.425578);
        dashLocation.setLongitude(-49.267360);
        local.setDashLocation(dashLocation);
        lista.add(local);

        local = new Local();
        local.setId(6);
        local.setNome("Banco Itau");
        tipo = new Tipo();
        local.setTipo(tipo.getTipo(4));
        local.setData(new Date());
        local.setStatus(true);
        local.setNota(2);
        local.setPreco(0);
        dashLocation = new DashLocation();
        dashLocation.setNome("Banco Itau");
        dashLocation.setLatitude(-25.430075);
        dashLocation.setLongitude(-49.266676);
        local.setDashLocation(dashLocation);
        lista.add(local);

        return lista;
    }

    public Local getLocal(Integer id) {
        return id > 0 && id < 7 ? getLista().get(id-1) : getLista().get(0);
    }
}
