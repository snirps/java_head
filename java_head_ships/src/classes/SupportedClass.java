package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SupportedClass {
    private static final String alfabet = "abcdefg";
    private int dlugoscPlanszy = 7;
    private int wielkoscPlanszy = 49;
    private int [] plansza = new int[wielkoscPlanszy];
    private int iloscPortali = 0;

    public String downloadInputData(String komunikat) {
        String daneWejsciowe = null;
        System.out.print(komunikat + "  ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            daneWejsciowe = is.readLine();
            if (daneWejsciowe.length() == 0 )  return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return daneWejsciowe.toLowerCase();
    }

    public ArrayList locatesPortal(int wielkoscPortalu) {
        ArrayList<String> zajetePola = new ArrayList<String>();
        String [] wspolrzedneLnc = new String [wielkoscPortalu]; // zawiera wspó³rzêdne zapisane jako 'f6'
        String pomoc = null;                                // pomocniczy ³añcuch znaków
        int [] wspolrzedne = new int[wielkoscPortalu];      // bie¿¹ce proponowane wspó³rzêdne
        int prob = 0;                                       // licznik iloœci prób
        boolean powodzenie = false;                         // flaga = czy znaleziono dobre miejsce
        int polozenie = 0;                                  // bie¿¹ce miejsce pocz¹tkowe

        iloscPortali++;                                     // n-ty portal do rozmieszczenia
        int inkr = 1;                                       // okreœlenie przyrostu w poziomie
        if ((iloscPortali % 2) == 1) {                      // jeœli nieparzysty portal (rozmieszczany w pionie)
            inkr = dlugoscPlanszy;                            // okreœlenie przyrostu w pionie
        }

        while (!powodzenie & prob++ < 200 ) {                 // g³ówna pêtla poszukiwania
            polozenie = (int) (Math.random() * wielkoscPlanszy);  // wybór losowego punktu pocz¹tkowego
            //System.out.print(" sprawdŸ " + location);
            int x = 0;                                          // n-ty fragment rozmieszczanego portalu
            powodzenie = true;                                  // zak³adamy, ¿e siê uda³o
            while (powodzenie && x < wielkoscPortalu) {         // szukamy s¹siaduj¹cych pustych pól planszy
                if (plansza[polozenie] == 0) {                    // jeœli jeszcze nie zajête
                    wspolrzedne[x++] = polozenie;                   // zapisujemy miejsce
                    polozenie += inkr;                              // sprawdzamy 'nastêpne' s¹siaduj¹ce pole
                    if (polozenie >= wielkoscPlanszy){              // poza zakresem - 'dó³' planszy
                        powodzenie = false;                           // niepowodzenie
                    }
                    if (x>0 & (polozenie % dlugoscPlanszy == 0)) {  // poza zakresem - prawa krawêdŸ planszy
                        powodzenie = false;                           // niepowodzenie
                    }
                } else {                                          // znalezione pole ju¿ jest zajête
                    // System.out.print(" ju¿ zajête " + location);
                    powodzenie = false;                             // niepowodzenie
                }
            }
        }                                                     // koniec while

        int x = 0;                                            // zamieniamy na wspó³rzêdne
        int wiersz = 0;
        int kolumna = 0;
        while (x < wielkoscPortalu) {
            plansza[wspolrzedne[x]] = 1;                        // zaznaczamy pole planszy jako zajête
            wiersz = (int) (wspolrzedne[x] / dlugoscPlanszy);   // okreœlenie wiersza
            kolumna = wspolrzedne[x] % dlugoscPlanszy;          // pobranie liczby okreœlaj¹cej kolumnê
            pomoc = String.valueOf(alfabet.charAt(kolumna));    // konwersja do postaci alfanumerycznej

            zajetePola.add(pomoc.concat(Integer.toString(wiersz)));
            x++;
            // System.out.print(" wspó³rzêdne "+x+" = "+zajetePola.get(x-1));
        }
        //System.out.println("\n");

        return zajetePola;
    }
}
