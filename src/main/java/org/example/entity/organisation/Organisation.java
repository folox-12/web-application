package org.example.entity.organisation;

import org.springframework.stereotype.Component;

@Component
public class Organisation {
    public String ID;
    public String INN;
    public String Name;
    public String  Residence;
    public String StoreDate;
    public String BlockDate;

    @Override
    public String toString() {
        return "Organisation{" +
                "ID='" + ID + '\'' +
                ", INN='" + INN + '\'' +
                ", Name='" + Name + '\'' +
                ", Residence='" + Residence + '\'' +
                ", StoreDate='" + StoreDate + '\'' +
                ", BlockDate='" + BlockDate + '\'' +
                '}';
    }
}
