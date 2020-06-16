package solid.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SingleResponsibilityPrinciple {

// Should have just a single reason to change
    // Too many responsibilities leads to a 'God object'
// Separation of concerns - different classes handling different, independent tasks/problems


}

class Journal {

    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {

        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index) {

        entries.remove(index);
    }

    @Override
    public String toString() {

        return String.join(System.lineSeparator(), entries);
    }

    /*
    Here we break SRP

    Saving, loading breaks SRP - it's on top of existing entry functionality.
    Saving and loading are separate concerns - create a Persistence class.
    Journal stores and manipulates entries.
     */
    public void save(String filename) throws FileNotFoundException {

        try (PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }

    public void load(String filename) {

    }
    public void load(URL url) {}
}

class Persistence {

    void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {

        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }
    public Journal load(String filename) {
        return null;
    }
}

class Demo {
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("I have a hangover");
        j.addEntry("Grilling today!");
        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "/tmp/journal.txt";
        p.saveToFile(j, filename, true);

        Runtime.getRuntime().exec("gvim " + filename);
    }
}
