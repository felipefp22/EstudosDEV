package Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
    private int id;
    private String name;
    private List<Phone> phones = new ArrayList<Phone>();
    private List<Email> email = new ArrayList<Email>();

    public boolean equals(Object obj){
        boolean result = false;
        if (obj instanceof Contact){
            Contact c = (Contact) obj;
            result = c.getId() == this.getId();
        }
        return result;
    }

    public int hashCode(){
        return getId() ^ 7;
    }
}
