/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.main;

import java.util.ArrayList;

/**
 *
 * @author 42079
 */
public class Databaze {
    private ArrayList<Pojistenec> pojistenci;

    public Databaze() {
        pojistenci = new ArrayList<>();
    }

    public void pridejPojistence(String jmeno, String prijmeni, int vek, int telefon) {
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telefon));
    }

    public ArrayList<Pojistenec> najdiVsechnyPojistence() {
        ArrayList<Pojistenec> nalezeniPojistenci = new ArrayList<>();
        for (Pojistenec pojistenec : pojistenci) {
            nalezeniPojistenci.add(pojistenec);
        }
        return nalezeniPojistenci;
    }

    public ArrayList<Pojistenec> najdiPojistence(String jmeno, String prijmeni) {
        ArrayList<Pojistenec> nalezeniPojistenci = new ArrayList<>();
        for (Pojistenec pojistenec : pojistenci) {
            if (pojistenec.getJmeno().toLowerCase().trim().equals(jmeno)
                    && pojistenec.getPrijmeni().toLowerCase().trim().equals(prijmeni)) {
                nalezeniPojistenci.add(pojistenec);
            }
        }
        return nalezeniPojistenci;
    }

    public ArrayList<Pojistenec> getPojistenci() {
        return this.pojistenci;
    }

    public void setPojistenci(ArrayList<Pojistenec> pojistenci) {
        this.pojistenci = pojistenci;
    }
    @Override
    public String toString() {
    String s = "";
    for (Pojistenec pojistenec : pojistenci) {
        s += pojistenec.textovyVypis() + " \n";
    }
    return s;
    }
}
