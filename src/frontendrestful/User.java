package frontendrestful;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private final StringProperty idUser;
    private final StringProperty name;
    private final StringProperty gender;
    private final StringProperty address;

    public User(String idUser, String name, String gender, String address) {
        this.idUser =new SimpleStringProperty(idUser);
        this.name =new SimpleStringProperty(name);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
    }

    public String getIdUser() {
        return idUser.get();
    }

    public void setIdUser(String value) {
        idUser.set(value);
    }
    public StringProperty userIdProperty() {
		return idUser;
	}

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }
    public StringProperty nameProperty() {
		return name;
	}

    public String getGender() {
        return gender.get();
    }

    public void setGender(String value) {
        gender.set(value);
    }
    public StringProperty genderProperty() {
		return gender;
	}

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String value) {
        address.set(value);
    }
    
    public StringProperty addressProperty() {
		return address;
	}
    
    
    
}
