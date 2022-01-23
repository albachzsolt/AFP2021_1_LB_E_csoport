# <div align="center">Tesztjegyzőkönyv </div>
<hr>

## Tesztjegyzőkönyvet írta:
|  | |
| --- | --- |
| Név: | Veres Szabolcs  |
| Neptun kód: | NY4KT5|
| Dátum: | 2021.01.23. |
| Böngésző: | Chrome; 97.0.4692.71 (Hivatalos verzió) (64 bites)|
| Operációs rendszer: | Windows 11 Pro |

<hr> 

## Tesztelendő feladatok:
#### 1.	Bejelentkezés Admin-ként
#### 2.	Menu megjelenítés
#### 3.	**Order History** tesztelése
#### 4.	Kijelentkezés


<hr>


## 1. Bejelentkezés Admin-ként 
|Lépés| Feladat | Teszt |
| --- | ------- | ----------- |
| 1.    | Weboldal megnyitása | Sikeres|
| 2.    | A menüben található **Login** menüpontra kattintva elnavigálunk a beléptető oldalra |Sikeres|
| 3.    | Megjelenik a bejelentkezési űrlap |Sikeres|
| 4.    | A **Username** mezőbe kattintunk |Sikeres|
| 5.    | A mezőt kitöltjük a már beregisztrált fiókhoz tartozó felhasználónévvel |Sikeres|
| 6.  A | Megnyomva a tabulátor billentyűt, a következő mezőre ugrik a kurzor és manuálisan is átkattinthatunk |Sikeres|
| 6.  B | A **Password** mezőbe kattintunk |Sikeres|
| 7.  A | Kitöltjük a jelszó mezőt tetszőleges karakterek kombinációjával, legalább 5 karakter hosszúságban, a saját már beregisztrált fiókunkhoz tartozó jelszóval |Sikeres|
| 7. B | A jelszó rejtve marad, csak csillag ("*") ikonok jelennek meg a |Sikeres|
| 8. A | Megnyomjuk a tabulátor billentyűt, ezáltal a **Log in** gomb kerül kijelölésre |Sikeres|
| 8. B | Manuálisan rákattintunk a Bejelentkezés gombra |Sikeres|
| 9.   | A rendszer automatikusan átirányít egy rövid idő után a felhasználó 'Kezdőlap' oldalára |Sikeres|
| 10.  | A menüpontok megváltoznak **Admin** és **Logout** menüpontokra |Sikeres|
| 11.  | A menüsor jobb oldalán megjelenik az üdvözlő üzenet a felhasználónevünket megjelenítve  |Sikeres|

<hr>

## 2. Menu megjelenítés
|Lépés| Feladat | Teszt |
| --- | ------- | ----------- |
| 1.   | Weboldal megnyitása |Sikeres|
| 2.  A | A menüsorban található **Admin** gombra húzva az egeret lenyíló menüben megjelennek az almenü **Order history**, **Dashboard**, **Users**, **Products**, **Reports** és **Categories** menüpontjai  |Sikeres|
| 2.  B | Újra az **Admin** gombra húzva az egeret a lenyíló menü eltűnik |Sikeres|
| 3.   | Az egyes almenük fölé húzva az egeret a menüpontok hátterének színe megváltozik |Sikeres|
| 4.   | Rákattintva az **Order history** gombra, elnavigálunk a megfelelő oldalra és megjelenik egy táblázat a korábbi rendelési adatokkal |Sikeres|
| 5.   | Rákattintva az **Dashboard** gombra, elnavigálunk a megfelelő oldalra és megjelennek a kördiagrammok |Sikeres|
| 6.   | Rákattintva az **Users** gombra, elnavigálunk a megfelelő oldalra és megjelenik egy táblázat a regisztrált felhasználók adataival|Sikeres|
| 7.   | Rákattintva az **Products** gombra, elnavigálunk a megfelelő oldalra és megjelennek a termékek kategóriák szerint csoportosítva |Sikeres|
| 8.   | Rákattintva az **Reports** gombra, elnavigálunk a megfelelő oldalra és megjelennek a szükséges táblázatok|Sikeres|
| 9.   | Rákattintva az **Categories** gombra, elnavigálunk a megfelelő oldalra és megjelennek a kategóriák felsorolva |Sikeres|

<hr>

## 3. **Order History** tesztelése 
|Lépés| Feladat | Teszt |
| --- | ------- | ----------- |
| 1.    | Weboldal megnyitása |Sikeres|
| 2.   | Rákattintva az **Order history** gombra, elnavigálunk a megfelelő oldalra és megjelenik egy táblázat a korábbi rendelési adatokkal |Sikeres|
| 3.   | A táblázat fölé húzva az egeret a kijelölt sor kivételével a táblázat sorai elhomályosulnak |Sikeres|
| 4.   | Rákattintva a táblázat egyes soraira, a rendszer átirányít a rendelés részletes adataihoz|Sikeres|
| 5.   | Az egyes sorok végén található szemetes ikonra kattintva megjelenik egy megerősítést kérő ablak |Sikeres|
| 6.  A | Megerősítést követően az adott sor törlődik a táblázatból |Sikeres|
| 6.  B | Megjelenik egy visszajelzés, miszerint sikeresen töröltük a terméket|Sikeres|
| 6.  C | Az oldalon a kitörölt sor nem jelenik meg |Sikeres|
| 7.   | A vissza nyílra kattintva visszatérünk az **Order history** oldalra |Sikeres|
| 8.   | A táblázat sorainak végén található **Delete order** gombra kattintva megjelenik egy megerősítést kérő ablak|Sikeres|
| 9.  A | Megerősítést követően az adott sor törlődik a táblázatból |Sikeres|
| 9.  B | Megjelenik egy visszajelzés, miszerint sikeresen töröltük a rendelést|Sikeres|
| 9.  C | Az oldalon a kitörölt sor nem jelenik meg |Sikeres|
| 10.  A | Megerősítést követően az adott sor törlése sikertelen **DELIVERED** **Order status** esetén |Sikeres|
| 10.  B | Megjelenik egy visszajelzés, miszerint a törlés sikertelen|Sikeres|
| 10.  C | Az oldalon a kitörölni kívánt sor megjelenik |Sikeres|
| 11.   | A táblázat sorainak végén található **Delivered** gombra kattintva megjelenik egy megerősítést kérő ablak|Sikeres|
| 12.  A | Megerősítést követően az adott sor **Order status**-a **DELIVERED**-re módosul|Sikeres|
| 12.  B | Megjelenik egy visszajelzés, miszerint sikeresen módosítottuk a rendelést|Sikeres|
| 13.   | Az oldal alján a szűrők lenyíló menüjére kattintunk |Sikeres|
| 14.   | Megjelenik a lenyíló menü **List all**, **Active**, **Delivered** és **Deleted** menüpontokkal |Sikeres|
| 15.  A | Az **Active** menüpontot kiválasztjuk |Sikeres|
| 15.  B | **Filter** gombra kattintva a táblázat azon sorai jelennek meg, ahol **ACTIVE** az **Order status** |Sikeres|
| 16.  A | A **Delivered** menüpontot kiválasztjuk |Sikeres|
| 16.  B | **Filter** gombra kattintva a táblázat azon sorai jelennek meg, ahol **DELIVERED** az **Order status** |Sikeres|
| 17.  A | A **Deleted** menüpontot kiválasztjuk |Sikeres|
| 17.  B | **Filter** gombra kattintva a táblázat azon sorai jelennek meg, ahol **DELETED** az **Order status** |Sikeres|
| 18.  A | A **List all** menüpontot kiválasztjuk |Sikeres|
| 18.  B | **Filter** gombra kattintva a táblázat összes sora megjelenik |Sikeres|

<hr>

## 4. Kijelentkezés 
|Lépés| Feladat | Teszt|
| --- | ------- | ----------- |
| 1.   | Weboldal megnyitása. |Sikeres|
| 2.   | A menüsorban található **Logout** gombra kattintunk|Sikeres|
| 3.   | Kattintás után a főoldalra kerülünk |Sikeres|
| 4.   | A menüsorban megjelenik a **Login** és **Sign up** gomb |Sikeres|
| 5.   | A menüsorban már nem látszódik az üdvözlő szöveg |Sikeres|
