# Webshop követelmény specifikáció


### 1. Jelenlegi helyzet

A Greenhub vállalkozásunk több, kifejezetten környezetbarát terméket árusít. Fontos számunkra, hogy a lehető legkisebb környezeti lábnyomot hagyjuk magunk után, ezért a nálunk kapható összes termék vagy újrahasznosított alapanyagból, vagy biológiailag lebomló anyagból készül.
Különösen figyelünk a termékek csomagolására is, nem használunk semmilyen műanyag csomagolóanyagot sem. Jelenleg csak vásárokban, illetve az online piactereken (Marketplace, Jófogás, Ebay) áruljuk termékeinket.
Minden megrendelés telefonon vagy emailen keresztül történik, ezeket pedig egy egyszerű Excel táblázatban vezetjük. Ebben a táblázatban vezetve van, hogy ki mit vásárolt, a termékekből hány darabot kért, illetve, hogy hova kell küldenünk a csomagot.
Minden vásárlás utánvétes csomagküldéssel kerül feladásra, kérhető csomagautómatába, illetve házhoz szállítva is. Sajnos az Excel táblázatban való nyilvántartás sokszor problémát okozott, nem került bele egy rendelés, rosszul lett felvéve/beírva és a végén előfordult, hogy az ügyfél rossz terméket kapott, illetve olyan is, hogy egyáltalán nem kapott terméket.

## Megrendelői igényspecifikáció (megrendelő által megfogalmazott igények, célok, követelmények):

### 2. Megrendelői vízió (Vágyálom)

Vállalkozásunk bővítése érdekében szeretnénk üzletünknek honlapot és egyúttal az adminisztrációnkat támogató rendszert. Szeretnénk, hogy ügyfeleink minden termékünket könnyedén megtalálhassák egy igényes és szép weboldalon.
Szeretnénk nyilvántartásunkat online kezelni, hogy az ügyvezetők bárhonnan rá tudjanak nézni az aktuális információkra. A web oldal könnyen üzemeltethető legyen, külön szintű belépési rendszerrel (admin, user). Termékeket fel lehessen tölteni, módosítani, különböző kategóriákba besorolni. 
A kategóriákat ugyanúgy lehessen bővíteni, szerkeszteni, törölni. Kimutatásokat szeretnénk elérni az oldalon keresztül, illetve egy áttekinhető külön oldalt, ahol azonnal látjuk, hány regisztrált ügyfelünk van, hány megrendelés és azok milyen státusban vannak, valamit hány termék van aktív, illetve törölt állapotban.
Szeretnénk ha az ügyfelek a vásárolt termékekről véleményt is írhatnak (szöveges illetve csillagos értékelést egyaránt), de csak a megrendelt temékek kiszállítása után. Természetesen az ügyfelek regisztrációt követően vissza tudják nézni a korábbi rendelésüket,  valamint azok állapotát.

### 3. Jelenlegi üzleti folyamatok

3.1. Termékek egyesével való feltöltése különböző online értékesítési platformokra  
3.2. Termékek rendelés kezelése (telefonon vagy emailen keresztül)  
3.2.1. Rendelés felvitele az Excel táblázatban  
3.2.2. Rendelés összekészítése és csomagolása  
3.2.3. Rendelés futárral való kézbesítése  
3.2.4. Excel táblázat frissítése

### 4. Igényelt üzleti folyamatok

4.1. Saját webshop ahol az összes termék megtalálható  
4.2. Különböző szintű belépési lehetőség -> admin és user  
4.3 Különböző menük a jogokhoz  
  4.3.1. admin menü  
    4.3.1.1. termékek feltöltése, módosítása, törlése  
    4.3.1.2. kategóriák kezelése (hozzáadás, módosítás, törlés)  
    4.3.1.3. kimutatások megtekintése   
    4.3.1.4. rendelések kezelése  
    4.3.1.5. userek kezelése (törlés, módosítás)  
  4.3.2. user menü  
    4.3.2.1. rendelések megtekintése  
    4.3.2.2. satát profil megtekintése illetve módosítása (name, username, password)  
    4.3.2.3. kategóriák szerinti termék szűrés  
    4.3.2.4. kosár  
4.4. Megrendelt, illetve kiszállított termékekre az ügyfelek értékelést tudnak leadni  
4.5. Error page ha nem megfelelő oldalra téved az ügyfél

### 5. A rendszerre vonatkozó szabályok

A web felület szabványos eszközökkel készüljön, html/css/javascript. Backend java nyelven írodjon és MySQL adatbázishoz csatlakozzon. Responsive megjelenés nem kell.  
A felhasználókat azonosító web oldalak esetében szükséges jogszabályokat be kell tartani: GDPR, ...

### 6. Követelménylista

ID|Verzió|Név|Kifejtés
--|------|---|--------
K01|V1.0|Termékek adminisztrációja|Termékek regisztrálása, törlése az igényelt üzleti folyamatokban leírtak szerint.
K02|V1.0|Vásárlás adminisztrációja|Vásárlások folyamatának kezelése az igényelt üzleti folyamatokban leírtak szerint.
K03|V1.0|Felhasználói fiókok kezelése|Bejelentkezés, felhasználói adatok módosítása, adminok és felhasználók rögzítése az adatbázisban, listák és kimutatások készítése az igényelt üzleti folyamatokban leírtak szerint.
K04|V1.0|Egyszerűen használható kezelőfelület|Az ismertebb böngészőkből használható felhasználói felület megvalósítása, amely mindenki számára a lehető legegyszerűbb átállást eredményezi.
K05|V1.0|Platformfüggetlen működés|Régóta használatos, operációs rendszertől független technológiák használata: Java, HTML/CSS/JavaScript, MySQL.
K06|V1.0|Költséghatékony üzemeltetés|A szabványos és elterjedt technológiák használata biztosítja.
K07|V1.0|Bővíthetőség|A termékek, valamint a felhasználók számának bővíthetősége, illetve új funkciók utólagos hozzáadásának biztosítása.

### 7. Fogalomszótár

- **Utánvétes csomagküldés**: Az utánvétes csomagküldés főleg a vevőnek hasznos, mert a csomag ellenértékét csak akkor kell kifizetnie, amikor ténylegesen átveszi a csomagot.
- **Csillagos értékelés**: A vásárlók 1-től 5-ig értékelhetik a termékeket, ami az adott számú csillag kijelölésével történik. A többi látogató minden terméknél az összesített értékelést látja.
- **Online értékesítési platform**: Olyan internetes piactér, ahol a vásárlók ugyanúgy válogathatnak a termékekből, mintha a valóságban tennék ugyanezt.