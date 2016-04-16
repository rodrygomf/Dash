package nx.kernnel.dash.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rodrigo Figueiredo on 14/04/2016.
 */
public class Pessoa implements Serializable {
    private Integer id;
    private String nome;
    private Date dataNasc;
    private Boolean sexo;
    private Date data;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public DashLocation getDashLocation() {
        return dashLocation;
    }

    public void setDashLocation(DashLocation dashLocation) {
        this.dashLocation = dashLocation;
    }
}
