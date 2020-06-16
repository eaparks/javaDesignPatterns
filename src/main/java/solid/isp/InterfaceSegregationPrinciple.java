package solid.isp;

public class InterfaceSegregationPrinciple {

    // How to split interfaces into smaller interfaces
    // Don't put too much into an interface; spit into separate interfaces
}


class Document {

}

interface Machine {

    void print(Document d);

    void fax(Document d) throws Exception;

    void scan(Document d) throws Exception;
}

// ok if you need a multifunction machine
class MultiFunctionPrinter implements Machine {

    public void print(Document d) {
        //
    }

    public void fax(Document d) {
        //
    }

    public void scan(Document d) {
        //
    }
}

class OldFashionedPrinter implements Machine {

    public void print(Document d) {
        // yep
    }

    public void fax(Document d) throws Exception {

        throw new Exception();  // Forces interface to throw
    }

    public void scan(Document d) throws Exception {

        throw new Exception();  // Forces interface to throw
    }
}

interface Printer {

    void print(Document d) throws Exception;
}

interface IScanner {

    void scan(Document d) throws Exception;
}

class JustAPrinter implements Printer {

    public void print(Document d) {

    }
}

class Photocopier implements Printer, IScanner {

    public void print(Document d) throws Exception {

        throw new Exception();
    }

    public void scan(Document d) throws Exception {

        throw new Exception();
    }
}

interface MultiFunctionDevice extends Printer, IScanner //
{

}

class MultiFunctionMachine implements MultiFunctionDevice {

    // compose this out of several modules
    private Printer printer;
    private IScanner scanner;

    public MultiFunctionMachine(Printer printer, IScanner scanner) {

        this.printer = printer;
        this.scanner = scanner;
    }

    public void print(Document d) throws Exception {

        printer.print(d);
    }

    public void scan(Document d) throws Exception {

        scanner.scan(d);
    }
}
