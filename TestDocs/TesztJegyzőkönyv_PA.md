# <div align="center">Tesztjegyzőkönyv </div>
<hr>

## Tesztjegyzőkönyvet írta:
|  | |
| --- | --- |
| Név: | Pamlényi Artúr  |
| Neptun kód: | BPBU5H|
| Dátum: | 2021.01.23. |
| Böngésző: | Chrome; 97.0.4692.71 (Hivatalos verzió) (64 bites)|
| Operációs rendszer: | Windows 11 Home |

<hr> 

## Tesztelendő feladatok:
#### 1.	Admin felületen Dashboard menü tesztelése
#### 2.	Admin felületen Users menü tesztelése
#### 3.	Admin felületen Products menü tesztelése
#### 4.	Admin felületen Reports menü tesztelése


<hr>


## 1. Admin felületen Dashboard menü tesztelése 
|Lépés| Feladat | Teszt |
| --- | ------- | ----------- |
| 1.    | Dashboard fül megnyitása | Sikeres|
| 2.    | A felületen megjenik 2 diagramm |Sikeres|
| 3.    | Bal oldalon a Products diagramm jelenik meg |Sikeres|
| 4.    | Jobb oldalon az Orders diagramm jejenik meg |Sikeres|
| 5.    | Az egeret rávíve a diagrammra kiírja a tartalmat |Sikeres|
| 6.    | Az oldal középen feltünteti a regisztrált felhasználókat |Sikeres|
<hr>

## 2. Admin felületen Users menü tesztelése
|Lépés| Feladat | Teszt |
| --- | ------- | ----------- |
| 1.   | Users fül megnyitása |Sikeres|
| 2.   | A képernyőn megjelenik egy táblázat a felhasználólról  |Sikeres|
| 3.   | A felhasználóra víve az egeret, kiemeli azt |Sikeres|
| 4.   | A felhasználó sorában az Edit parancsra víve az egeret interakció jelenik meg |Sikeres|
| 5.   | A felhasználó sorában az Delete parancsra víve az egeret interakció jelenik meg |Sikeres|
| 6.   | Rákattintva az **Delete** gombra, megjelenik egy felugró ablak |Sikeres|
| 7.   | A felugró ablakban megkérdezi az oldal a törlést|Sikeres|
| 8.   | A felugró ablakban az **OK** gombra kattintva kitörlődik az adott felhasználó |Sikeres|
| 9.   | A felugró ablakban a **Mégse** gombra kattintva nem törlődik ki a felhasználó |Sikeres|
| 10.   | Rákattintva az **Edit** gombra, a felhasználó sorában megjelenik a szerkesztés|Sikeres|
| 11.   | Szerkeszteni lehet a nevét, felhasználónevét |Sikeres|
| 12.   | Az **Edit** gomb **Save** gombra változik |Sikeres|

<hr>

## 3. Admin felületen Products menü tesztelése
|Lépés| Feladat | Teszt |
| --- | ------- | ----------- |
| 1.   | Products fül megnyitása |Sikeres|
| 2.   | Megjelennek a termékek kategóriákra bontva |Sikeres|
| 3.   | A termékeknél megjelennek a kuka és csavarkulcs ikonok |Sikeres|
| 4.   | A termékeknél a kuka ikonra víve az egeret, megjelenik a kuka körül egy kijelölés |Sikeres|
| 5.   | A termékeknél a csavarkulcs inkonra víve az egeret, megjelenik a csavarkulcs körül egy kijelölés |Sikeres|
| 6.   | A termékeknél a kuka ikonra kattintva megjelnik egy felugró ablak |Sikeres|
| 7.   | A felugró ablak megkérdezi, hogy valóban törölni szeretné e a terméket |Sikeres|
| 8.   | A felugró ablakban az **OK** gombra kattintva kitörlődik a termék |Sikeres|
| 9.   | A felugró ablakban a **Mégse** gombra kattintva megmarad a termék |Sikeres|
| 10.   | A terméknél a csavarkulcs ikonra kattintva megjelennek a kategóriák, a státusz és egy mentés ikon (szerkesztés menü) |Sikeres|
| 11.   | A szerkesztés menüben a státusz fülnél legördül az aktív és inaktív lehetőség |Sikeres|
| 12.   | A szerkesztés menüben a kategóriák fülnél legördülnek a választható kategóriák |Sikeres|
| 13.   | A mentés ikonra kattintva elmenti az állapotot, és visszatér az előző státusz, csak a kuka és csavarkulcs ikon aktív |Sikeres|
| 14.   | Az **Add new item** gombra kattintva megjelenik a termék hozzáadása lehetőség |Sikeres|
| 15.   | Az első sorban a termék kódját lehet megadni, belekattintva aktív a billentyűzet, lehet írni az ablakba |Sikeres|
| 16.   | A második sorban a termék nevét lehet megadni, belekattintva aktív a billentyűzet, lehet írni az ablakba |Sikeres|
| 17.   | A harmadik sorban a termék gyártóját lehet megadni, belekattintva aktív a billentyűzet, lehet írni az ablakba |Sikeres|
| 18.   | A negyedik sorban a termék árát lehet megani, belekattintva aktív a billentyűzet, lehet írni az ablakba |Sikeres|
| 19.   | Az ötödik sorban egy legördülő menü jön be, megjelenítve a termék kategóriákat |Sikeres|
| 20.   | Az **Add** gombra víve az egeret, a gomb színe megváltozik |Sikeres|
| 21.   | Az **Add** gombra kattintva, minden sor kitöltése után megjelnik a Succesfully created, visszaigazoló üzenet |Sikeres|
| 22.   | Az **Add** gombra kattintva, hiányzó sor esetén, hibaüzenetet kapunk, hiányzó paramaéterek paranncsal |Sikeres|
| 23.   | Az oldal jobb alsó sarkában megjelenik egy felfelé mutató nyíl egy körben |Sikeres|
| 24.   | A felfelé mutató nyílra kattinva, bárhol is legyünk az oldalon, visszatér a tetejére az oldal |Sikeres|


<hr>

## 4. Admin felületen Reports menü tesztelése
|Lépés| Feladat | Teszt|
| --- | ------- | ----------- |
| 1.   | Reports fül megynitása |Sikeres|
| 2.   | Az oldaon megjelnik 2 táblázat a jelentésekről |Sikeres|
| 3.   | Ha az egeret rávisszük valamelyik sorra, megváltozik a sor betűszíne |Sikeres|
| 4.   | Felül megjelnik a Monthly breakdown felirat |Sikeres|

