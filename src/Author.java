public class Author {
    private String name;
    private int age;
    private long id;

    public Author(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.id = Identifiers.authorId++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }
}
