package clases;

public class infoPokemon{

    String name;

    String url;

    public infoPokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getNombre() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
