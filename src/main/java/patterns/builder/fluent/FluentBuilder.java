package patterns.builder.fluent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FluentBuilder {}

class HtmlElement_Fluent {

  public String name;
  public String text;
  public List<HtmlElement_Fluent> elements = new ArrayList<HtmlElement_Fluent>();
  private final int indentSize = 2;
  private final String newLine = System.lineSeparator();

  public HtmlElement_Fluent() {}

  public HtmlElement_Fluent(String name, String text) {
    this.name = name;
    this.text = text;
  }

  private String toStringImpl(int indent) {

    StringBuilder sb = new StringBuilder();
    String i = String.join("", Collections.nCopies(indent * indentSize, " "));
    sb.append(String.format("%s<%s>%s", i, name, newLine));
    if (text != null && !text.isEmpty()) {
      sb.append(String.join("", Collections.nCopies(indentSize * (indent + 1), " ")))
          .append(text)
          .append(newLine);
    }

    for (HtmlElement_Fluent e : elements) {
    	sb.append(e.toStringImpl(indent + 1));
	}

    sb.append(String.format("%s</%s>%s", i, name, newLine));
    return sb.toString();
  }

  @Override
  public String toString() {
    return toStringImpl(0);
  }
}

class HtmlBuilder_Fluent {

  private String rootName;
  private HtmlElement_Fluent root = new HtmlElement_Fluent();

  public HtmlBuilder_Fluent(String rootName) {
    this.rootName = rootName;
    root.name = rootName;
  }

  // not fluent
//  public void addChild(String childName, String childText) {
//    HtmlElement e = new HtmlElement(childName, childText);
//    root.elements.add(e);
//  }

  public HtmlBuilder_Fluent addChild(String childName, String childText) {
    HtmlElement_Fluent e = new HtmlElement_Fluent(childName, childText);
    root.elements.add(e);

    return this;
  }

  public HtmlBuilder_Fluent addChildFluent(String childName, String childText) {
    HtmlElement_Fluent e = new HtmlElement_Fluent(childName, childText);
    root.elements.add(e);
    return this;
  }

  public void clear() {
    root = new HtmlElement_Fluent();
    root.name = rootName;
  }

  // delegating
  @Override
  public String toString() {
    return root.toString();
  }
}

class BuilderDemo {

  public static void main(String[] args) {
    // we want to build a simple HTML paragraph
    System.out.println("Testing");
    String hello = "hello";
    StringBuilder sb = new StringBuilder();
    sb.append("<p>").append(hello).append("</p>"); // a builder!
    System.out.println(sb);

    // now we want to build a list with 2 words
    String[] words = {"hello", "world"};
    sb.setLength(0); // clear it
    sb.append("<ul>\n");
    for (String word : words) {
      // indentation management, line breaks and other evils
      sb.append(String.format("  <li>%s</li>\n", word));
    }
    sb.append("</ul>");
    System.out.println(sb);

    // ordinary non-fluent builder
    HtmlBuilder_Fluent builder = new HtmlBuilder_Fluent("ul");
//    builder.addChild("li", "hello");
//    builder.addChild("li", "world");


    // fluent builder
    builder.clear();
    builder
        .addChildFluent("li", "hello")
        .addChildFluent("li", "world");
    System.out.println(builder);
  }
}
