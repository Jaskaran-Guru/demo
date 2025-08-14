package example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.SessionFactory;

@Entity
public class Laptop {

    @Id
    int Lid;
    String Lname;

    public Laptop()
    {


    }

    public Laptop(int lid, String lname)
    {
        super();
        Lid = lid;
        Lname = lname;

    }
    public int getLid() {
        return Lid;
    }

    public static void main(String[] args) {


    }
}
