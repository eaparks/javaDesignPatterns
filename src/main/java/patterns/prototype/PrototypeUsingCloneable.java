package patterns.prototype;

import java.util.Arrays;

public class PrototypeUsingCloneable {
}
class CloneableAddress implements Cloneable {
    public String streetName;
    public int houseNumber;

    public CloneableAddress(String streetName, int houseNumber) {

        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    // deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {

        return new CloneableAddress(streetName, houseNumber);
    }

    @Override
    public String toString() {

        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}

class Person implements Cloneable {
    public String[] names;
    public CloneableAddress cloneableAddress;

    public Person(String[] names, CloneableAddress cloneableAddress) {
        this.names = names;
        this.cloneableAddress = cloneableAddress;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

//        return new Person(names, address);    // wrong
        return new Person(names.clone(), (CloneableAddress) cloneableAddress.clone());
    }

    @Override
    public String toString() {

        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + cloneableAddress +
                '}';
    }
}

class Demo {
  public static void main(String[] args) throws Exception {

    Person edward = new Person(new String[]{"Edward", "Parks"},
            new CloneableAddress("Main St", 123));

    Person kirsten = (Person) edward.clone();
    kirsten.names[0] = "Kirsten";
    kirsten.cloneableAddress.houseNumber = 124;

    System.out.println(edward);
    System.out.println(kirsten);
  }
}
