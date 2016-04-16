package nx.kernnel.dash.Entity;

import java.io.Serializable;

/**
 * Created by Rodrigo Figueiredo on 15/04/2016.
 */
public class DashLocation implements Serializable {
    private Double latitude;
    private Double longitude;
    private String nome;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
