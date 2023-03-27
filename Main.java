/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package cz.itnetwork.main;


import java.util.Scanner;

/**
 *
 * @author 42079
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        EvidencePojisteni evidencePojisteni = new EvidencePojisteni();
        // uživatelský vstup k cyklu
        String vstup = "";
        String pokracovat = "";
        //hlavní cyklus
        while (!vstup.equals("4")) {
            evidencePojisteni.vypisUvodniObrazovku();
            System.out.println();

            System.out.println("Vyberte si akci:");
            System.out.println("1 - Přidat pojištěnce");
            System.out.println("2 - Vyhledat konkrétního pojištěnce");
            System.out.println("3 - Vypsat všechny pojištěnce");
            System.out.println("4 - Konec");
        
            vstup = scanner.nextLine().trim().toLowerCase();
            
            System.out.println();
            //volby uživatele k zadání
            switch (vstup) {
                case "1" -> evidencePojisteni.pridejPojistence();
                case "2" -> evidencePojisteni.vyhledejPojistence();
                case "3" -> evidencePojisteni.vypisVsechnyPojistence();
                case "4" -> System.out.println("Libovolnou klávesou ukončíte program...");
                default -> System.out.println("Neplatná volba, stiskněte libovolnou klávesu a opakujte volbu.");
                }
            System.out.println("");
            System.out.println("");
            System.out.println("Pokračujte libovolnou klávesou...");
            pokracovat = scanner.nextLine();
            
        }
    }
}
