public class Patient implements Comparable<Patient> {
    String name;
    Integer emergencyLevel;


public int compareTo(Patient p) {

    int level = this.emergencyLevel.compareTo(p.emergencyLevel);
    if (level==0)
            return this.name.compareTo(p.name);
    else
            return level;
}
public String toString(){
    return "name = "+ name + " EL: "+ emergencyLevel;
}

    }