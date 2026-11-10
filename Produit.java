package tp;


import java.io.*;

public class Produit implements Serializable {

    private int num;
    private String designation;
    private float prix;

    public Produit(int num, String designation, float prix) {

        this.num = num;
        this.designation = designation;
        this.prix = prix;
    }

    public String toString() {

        return num + " -- " + designation + " -- " + prix;
    }
}

