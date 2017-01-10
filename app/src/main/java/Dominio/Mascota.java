package Dominio;

/**
 * Created by MacCesarR on 09/01/17.
 */

public class Mascota {

    int id;
    String name;
    int fotografía;
    int votación;


    public Mascota(int id, String name, int fotografía, int votación) {
        this.id = id;
        this.name = name;
        this.fotografía = fotografía;
        this.votación = votación;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFotografía() {
        return fotografía;
    }

    public void setFotografía(int fotografía) {
        this.fotografía = fotografía;
    }

    public int getVotación() {
        return votación;
    }

    public void setVotación(int votación) {
        this.votación = votación;
    }
}
