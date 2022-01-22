# <div align="center">Tesztjegyzőkönyv </div>
<hr>

## Tesztjegyzőkönyvet írta:
|  | |
| --- | --- |
| Név: | Guóth Kevin  |
| Neptun kód: | JP9FC7|
| Dátum: | 2021.01.22. |
| Böngésző: | Opera; 67.0.3575.97 (Hivatalos verzió) (64 bites) |
| Oprendszer: | Windows 10 Enterprise |

<hr> 

## Tesztelendő feladatok:
#### 1.	Regisztráció
#### 2.	Bejelentkezés
#### 3.	Kezdőlap
#### 4.	Termék kosárba helyezés


<hr>


## 1. Regisztráció
|Lépés| Feladat | Teszt |
| --- | ------- | ----------- |
| 1.    | Weboldal megnyitása | Sikeres|
| 2.  A | A menüben található **Sign up** menüpontra kattintanva elnavigálunk a regisztrációs oldalra |Sikeres|
| 2.  B | A menüben található **Login** menüpontra, majd a **create an account** linkre kattintanva elnavigálunk a regisztrációs oldalra |Sikeres|
| 3.    | Megjelenik a regisztrációs űrlap |Sikeres|
| 4.  A | A **Firs name** mezőbe kattintunk |Sikeres|
| 4.  B | A mezőt kitöltjük a magyar ABC és számjegyek tetszőleges kombinációjával legalább 3 karakter hosszan |Sikeres|
| 4.  C | Megnyomva a tabulátor billentyűt, a következő mezőre ugrik a kurzor és manuálisan is átkattinthatunk |Sikeres|
| 5.  A | A **Last name** mezőbe kattintunk |Sikeres|
| 5.  B | A mezőt kitöltjük a magyar ABC és számjegyek tetszőleges kombinációjával legalább 3 karakter hosszan |Sikeres|
| 5.  C | Megnyomva a tabulátor billentyűt, a következő mezőre ugrik a kurzor és manuálisan is átkattinthatunk |Sikeres|
| 6.  A | A **Username** mezőbe kattintunk |Sikeres|
| 6.  B | A mezőt kitöltjük a magyar ABC és számjegyek tetszőleges kombinációjával legalább 3 karakter hosszan |Sikeres|
| 6.  C | Megnyomva a tabulátor billentyűt, a következő mezőre ugrik a kurzor és manuálisan is átkattinthatunk |Sikeres|
| 7.  A | A **Password** mezőbe kattintunk és megjelennek a jelszóra vonatkozó elvárások |Sikeres|
| 7.  B | A mezőt kitöltjük a magyar ABC és számjegyek tetszőleges kombinációjával legalább 8 karakter |Sikeres|
| 7.  C | Megnyomva a tabulátor billentyűt, a következő mezőre ugrik a kurzor és manuálisan is átkattinthatunk |Sikeres|
| 8.  A | A **Re-type password** mezőbe kattintunk |Sikeres|
| 8.  B | A mezőt kitöltjük a magyar ABC és számjegyek tetszőleges kombinációjával legalább 3 karakter hosszan |Sikeres|
| 8.  C | Megnyomva a tabulátor billentyűt, a következő mezőre ugrik a kurzor és manuálisan is átkattinthatunk |Sikeres|
| 9.    | Megnyomjuk a tabulátor billentyűt, ezáltal a Regisztráció gomb kerül kijelölésre |Sikeres|
| 10.   | Manuálisan rákattintunk a Regisztráció gombra |Sikeres|
| 11.   | A rendszer az infó sávban jelzi a sikeres regisztrációt |Sikeres|
| 12.   | A rendszer az infó sávban jelzi a sikertelen regisztrációt |Sikeres|

<hr>

## 2. Bejelentkezés
|Lépés| Feladat | Teszt |
| --- | ------- | ----------- |
| 1.   | Weboldal megnyitása. |Sikeres|
| 2.   | A menüben található **Login** gombra kattintanva elnavigálunk a beléptető oldalra |Sikeres|
| 3.   | Megjelenik a bejelentkezési űrlap |Sikeres|
| 4.   | A **Username** mezőbe kattintunk |Sikeres|
| 5.   | A mezőt kitöltjük a magyar ABC és számjegyek tetszőleges kombinációjával legalább 3 karakter hosszan, a saját már beregisztrált fiókunkhoz tartozó felhasználó névvel |Sikeres|
| 6. A | Megnyomva a tabulátor billentyűt, a következő mezőre ugrik a kurzor |Sikeres|
| 6. B | Manuálisan is átkattinthatunk a következő mezőre (**Password**) |Sikeres|
| 7. A | Kitöltjük a jelszó mezőt tetszőleges karakterek kombinációjával, legalább 5 karakter hosszúságban, a saját már beregisztrált fiókunkhoz tartozó jelszóval |Sikeres|
| 7. B | A jelszó rejtve marad, csak csillag ("*") ikonok jelennek meg a |Sikeres|
| 8. A | Megnyomjuk a tabulátor billentyűt, ezáltal a **Log in** gomb kerül kijelölésre |Sikeres|
| 8. B | Manuálisan rákattintunk a Bejelentkezés gombra |Sikeres|
| 9.   | A rendszer automatikusan átirányít egy rövid idő után a felhasználó 'Kezdőlap' oldalára |Sikeres|
| 10.  | A menüpontok megváltoznak My Account, Categories és Logout menüpontokra |Sikeres|

<hr>

## 3. Kezdőlap
|Lépés| Feladat | Teszt |
| --- | ------- | ----------- |
| 1.    | Weboldal megnyitása |Sikeres|
| 2. A  | A felső menün kattintunk a középen található logóra |Sikeres|
| 2. B  | Megjelenik a kezdőlap |Sikeres|
| 3.    | Rákattintva a **SHOP NOW** gombra, legördul az oldal a termékekhez |Sikeres|
| 3. B  | Az egéren található görgővel, legörgetünk a termékekhez |Sikeres|
| 4.    | A főoldalon a legfelső részben megjelenik 3 ajánlott termék |Sikeres|
| 5.    | Az ajánlott termékek alatt categóriák szerint rendezve megjelenik az összes termék |Sikeres|
| 6.  A | A legördülő menüből kiválasztunk egy konkrét kategóriát |Sikeres|
| 6.  B | Kiválasztás után csak azok a termékek láthatók az oldalon |Sikeres|
| 7.  A | Rákattintunk a **Show All* gombra |Sikeres|
| 7.  B | Az oldalon újra az összes termék láthatóvá válik |Sikeres|

<hr>

## 4. Termék kosárba helyezés ##
|Lépés| Feladat | Teszt|
| --- | ------- | ----------- |
| 1.   | Weboldal megnyitása. |Sikeres|
| 2.   | A menüben található **Bejelentkezés** gombra kattintanva elnavigálunk a beléptető oldalra |Sikeres|
| 3.   | Megjelenik a bejelentkezési űrlap |Sikeres|
| 4.   | A **Username** mezőbe kattintunk |Sikeres|
| 5.   | A mezőt kitöltjük a magyar ABC és számjegyek tetszőleges kombinációjával a saját, már beregisztrált fiókunkhoz tartozó felhasználó névvel |Sikeres|
| 6. A | Megnyomva a tabulátor billentyűt, a következő mezőre ugrik a kurzor |Sikeres|
| 6. B | Manuálisan is átkattinthatunk a következő mezőre (**Password**) |Sikeres|
| 7.   | Kitöltjük a jelszó mezőt tetszőleges karakterek kombinációjával, legalább 8 karakter hosszúságban, a saját már beregisztrált fiókunkhoz tartozó jelszóval |Sikeres|
| 8. A | Megnyomjuk a tabulátor billentyűt, ezáltal a **Login** gomb kerül kijelölésre|Sikeres|
| 8. B | Manuálisan rákattintunk a Bejelentkezés gombra |Sikeres|
| 10.  | Autómatikusan megjelenik a kezdőlap |Sikeres|
| 11.  | Lejjebb görgetve rákattunktunk egy termékre |Sikeres|
| 12.  | Átkerülünk a termék adatlapjára  |Sikeres|
| 13. A | Kiválasztjuk mennyiséget |Sikeres|
| 13. B | 1-nél kisebb számot nem lehet beírni |Sikeres|
| 14. A| Rákattintva az **Add to cart** gombra a terméket a kosárba helyezzük |Sikeres|
| 14. B| A rendszer visszajelzést ad a sikeres kosárbahelyezésről "Succesfully added to basket." üzenettel |Sikeres|
| 15.  | A menüsor jobb oldálán rákattintva a kosár ikonra, megnyílik a kosár oldala |Sikeres|
| 16.  | A korábban kiválasztott termék látható a kosár oldalán |Sikeres|
