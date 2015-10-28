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
        String [] wspolrzedneLnc = new String [wielkoscPortalu]; // zawiera wsp�rz�dne zapisane jako 'f6'
        String pomoc = null;                                // pomocniczy �a�cuch znak�w
        int [] wspolrzedne = new int[wielkoscPortalu];      // bie��ce proponowane wsp�rz�dne
        int prob = 0;                                       // licznik ilo�ci pr�b
        boolean powodzenie = false;                         // flaga = czy znaleziono dobre miejsce
        int polozenie = 0;                                  // bie��ce miejsce pocz�tkowe

        iloscPortali++;                                     // n-ty portal do rozmieszczenia
        int inkr = 1;                                       // okre�lenie przyrostu w poziomie
        if ((iloscPortali % 2) == 1) {                      // je�li nieparzysty portal (rozmieszczany w pionie)
            inkr = dlugoscPlanszy;                            // okre�lenie przyrostu w pionie
        }

        while (!powodzenie & prob++ < 200 ) {                 // g��wna p�tla poszukiwania
            polozenie = (int) (Math.random() * wielkoscPlanszy);  // wyb�r losowego punktu pocz�tkowego
            //System.out.print(" sprawd� " + location);
            int x = 0;                                          // n-ty fragment rozmieszczanego portalu
            powodzenie = true;                                  // zak�adamy, �e si� uda�o
            while (powodzenie && x < wielkoscPortalu) {         // szukamy s�siaduj�cych pustych p�l planszy
                if (plansza[polozenie] == 0) {                    // je�li jeszcze nie zaj�te
                    wspolrzedne[x++] = polozenie;                   // zapisujemy miejsce
                    polozenie += inkr;                              // sprawdzamy 'nast�pne' s�siaduj�ce pole
                    if (polozenie >= wielkoscPlanszy){              // poza zakresem - 'd�' planszy
                        powodzenie = false;                           // niepowodzenie
                    }
                    if (x>0 & (polozenie % dlugoscPlanszy == 0)) {  // poza zakresem - prawa kraw�d� planszy
                        powodzenie = false;                           // niepowodzenie
                    }
                } else {                                          // znalezione pole ju� jest zaj�te
                    // System.out.print(" ju� zaj�te " + location);
                    powodzenie = false;                             // niepowodzenie
                }
            }
        }                                                     // koniec while

        int x = 0;                                            // zamieniamy na wsp�rz�dne
        int wiersz = 0;
        int kolumna = 0;
        while (x < wielkoscPortalu) {
            plansza[wspolrzedne[x]] = 1;                        // zaznaczamy pole planszy jako zaj�te
            wiersz = (int) (wspolrzedne[x] / dlugoscPlanszy);   // okre�lenie wiersza
            kolumna = wspolrzedne[x] % dlugoscPlanszy;          // pobranie liczby okre�laj�cej kolumn�
            pomoc = String.valueOf(alfabet.charAt(kolumna));    // konwersja do postaci alfanumerycznej

            zajetePola.add(pomoc.concat(Integer.toString(wiersz)));
            x++;
            // System.out.print(" wsp�rz�dne "+x+" = "+zajetePola.get(x-1));
        }
        //System.out.println("\n");

        return zajetePola;
    }
}
