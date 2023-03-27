/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 42079
 */
public class EvidencePojisteni {
    private Databaze databaze;
    private Scanner scanner = new Scanner(System.in, "Windows-1250");

    public EvidencePojisteni() {
        databaze = new Databaze();
    }
    //nadpis před volby
    public void vypisUvodniObrazovku() {
        System.out.println("-------------------------");
        System.out.println("Evidence pojištěných.");
        System.out.println("-------------------------");
    }
    
    //vypsání všech pojištěnců, uložených v evidenci
    public void vypisVsechnyPojistence() {
        ArrayList<Pojistenec> zaznamy = databaze.najdiVsechnyPojistence();
        if (zaznamy.isEmpty()){
            System.out.println("Nebyli nalezeni žádní pojištěnci. ");
        }
        for (Pojistenec pojistenec : zaznamy) {
            System.out.println(pojistenec);
        }
    }
    // přidání pojištěnce do evidence
    public void pridejPojistence() {
        String jmeno = zadejJmeno();
        String prijmeni = zadejPrijmeni();
        int vek = zadejVek();
        int telefon = zadejTelefon();
        databaze.pridejPojistence(jmeno, prijmeni, vek, telefon);
        System.out.println("Pojištěnec byl úspěšně vložen!");
    }
    // vyhledání specifického pojištence
    public void vyhledejPojistence() {
        String jmeno = zadejJmeno();
        String prijmeni = zadejPrijmeni();
        ArrayList<Pojistenec> pojistenci = databaze.najdiPojistence(jmeno.toLowerCase(), prijmeni.toLowerCase());
        if (!pojistenci.isEmpty()) {
            System.out.println("Nalezeni tito pojištěnci: ");
            for (Pojistenec pojistenec : pojistenci) {
                System.out.println(pojistenec);
            }
        } else {

            System.out.println("Nebyli nalezeni žádní pojištěnci");
        }
    }

    public String textovyExport(){
       String textovyVypis = databaze.toString();
       return textovyVypis;
    }
    // specifikace jména
    private String zadejJmeno() {
        System.out.println("Zadejte křestní jméno :");
        String jmeno = scanner.nextLine().trim();
        while (jmeno.length()>15||jmeno.length()<2) {
            System.out.println("Příliš krátké nebo dlouhé jméno. Vložte prosím znovu.");
            jmeno = scanner.nextLine().trim();
        }
        return jmeno;
    }
    // specifikace příjmení
    private String zadejPrijmeni() {
        System.out.println("Zadejte příjmení :");
        String prijmeni = scanner.nextLine().trim();
        while (prijmeni.length() > 15 || prijmeni.length() < 2) {
            System.out.println("Příliš krátké nebo dlouhé příjmení. Vložte prosím znovu.");
            prijmeni = scanner.nextLine().trim();
        }
        return prijmeni;
    }
    // specifikace věku
    private int zadejVek() {
        System.out.println("Zadejte věk:");
        int vek = 0;
        while (vek == 0) {
            try {
                vek = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Neplatná hodnota. Věk zadávejte čísly.");
            }
        }
        return vek;
    }
    // specifikace telefonního čísla
    private int zadejTelefon() {
        System.out.println("Zadejte telefon bez mezer mezi čísly:");
        int telefon = 0;
        while (telefon == 0 || telefon < 100000000 || telefon > 999999999) {
            try {

                telefon = Integer.parseInt(scanner.nextLine().trim());

            } catch (Exception e) {
                System.out.println("Neplatné telefonní číslo, zadejte prosím znovu.");
                continue;
            }
            if (telefon < 100000000 || telefon > 999999999)
                System.out.println("Příliš krátké nebo dlouhé telefonní číslo. Zadejte prosím znovu.");
        }
        return telefon;
    }
}
