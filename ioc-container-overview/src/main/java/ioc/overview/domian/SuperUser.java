package ioc.overview.domian;

import ioc.overview.annotation.Super;

@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "name='" + getName() + '\'' +
                ", id=" + getId() +
                ", address='" + address + '\'' +
                '}';
    }
}
