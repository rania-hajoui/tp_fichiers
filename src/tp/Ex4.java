package tp;


import java.io.*;
import java.util.ArrayList;

public class Ex4 {

    static void sauvegarder(ArrayList<Produit> liste, String nom)throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nom));
        oos.writeObject(liste);
        oos.close();
    }

    static ArrayList<Produit> charger(String nom)throws IOException, ClassNotFoundException {

        File fichier = new File(nom);
        if (!fichier.exists()) {
            return new ArrayList<Produit>();
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));

        ArrayList<Produit> liste =(ArrayList<Produit>) ois.readObject();
        ois.close();

        return liste;
    }

    public static void main(String[] args) {

        String nom = "C:\\Users\\Assil\\Documents\\tp_fichiers\\stock.dat";

        ArrayList<Produit> liste = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Assil\\Documents\\tp_fichiers\\produits.txt"));

            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] tab = ligne.split(";");
                int num = Integer.parseInt(tab[0]);
                String designation = tab[1];
                float prix = Float.parseFloat(tab[2]);
                
                Produit p = new Produit(num, designation, prix);
                liste.add(p);
            }
            br.close();

            sauvegarder(liste, nom);
            System.out.println(liste.size()+ " produits sauvegardes");

            liste = charger(nom);
            Produit p = new Produit(6, "Webcam", 350);

            liste.add(p);
            sauvegarder(liste, nom);

            liste = charger(nom);
            for (Produit produit : liste) {
                System.out.println(produit);
            }

        } catch (FileNotFoundException e) {

            System.out.println("Fichier introuvable");

        } catch (IOException e) {

            System.out.println("Erreur de lecture ou ecriture");

        } catch (ClassNotFoundException e) {

            System.out.println("Classe introuvable");
        }
    }
}

