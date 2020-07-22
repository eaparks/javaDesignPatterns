package patterns.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class CopyThroughSerialization {
}

class FooSerializable implements Serializable {
    public int answer;
    public String whatever;

    public FooSerializable(int answer, String whatever) {
        this.answer = answer;
        this.whatever = whatever;
    }

    @Override
    public String toString() {

        return "Foo{" +
                "answer=" + answer +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}

class SerializationDemo {

  public static void main(String[] args) {

      FooSerializable foo = new FooSerializable(42, "whatever");
      FooSerializable foo2 = SerializationUtils.roundtrip(foo);

      foo2.whatever = "xyz";

    System.out.println(foo);
    System.out.println(foo2);
  }
}
