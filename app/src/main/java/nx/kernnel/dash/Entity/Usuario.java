package nx.kernnel.dash.Entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Rodrigo Figueiredo on 14/04/2016.
 */
public class Usuario extends Pessoa implements Serializable {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean userValidate() {
        if(login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            this.setNome("Usuario Padrao");
            this.setSexo(true);
            Calendar calendario = Calendar.getInstance();
            calendario.set(1990, 1, 1);
            this.setDataNasc(calendario.getTime());
            this.setData(new Date());
            this.setId(1);
            DashLocation dashLocation = new DashLocation();
            dashLocation.setNome("Centro");
            dashLocation.setLatitude(-25.429694);
            dashLocation.setLongitude(-49.271265);
            this.setDashLocation(dashLocation);
            return true;
        }
        return false;
    }
}
