package patterns.builder;

public class Builder {

}

class Demo {

    public static void main(String[] args) {
        String hello = "hello";
        System.out.println("<p>" + hello + "</p");

        String[] words = {"hello", "world"};
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for (String word : words) {
            sb.append(String.format("  <li>%s</li>\n", word));
        }
        sb.append("</ul>");
        System.out.println(sb.toString());
    }
}
