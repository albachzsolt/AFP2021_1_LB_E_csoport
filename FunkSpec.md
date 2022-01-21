# Funkcionális Specifikáció

### 1. A rendszer céljai

A követelmény specifikációban említett webshop rendszer elkészítése, ahol a felhasználónak és admin jogokkal rendelkező személyeknek külön felület érhető el.


### 2. Jelenlegi helyzet leírása

A termékek jelenleg vásárokban és különböző online vásárterekben kerülnek értékesítésre. A rendelések egy excel táblázatban vannak vezetve, amihez több személy is hozzáfér.
Ebből adódóan a múltban történtek már a rendelésekkel kapcsolatos félreértések.


### 3. Vágyálom rendszer leírása

Hivatkozás a követelmény specifikáció 2. pontjára:

Vállalkozásunk bővítése érdekében szeretnénk üzletünknek honlapot és egyúttal az adminisztrációnkat támogató rendszert.
Szeretnénk, hogy ügyfeleink minden termékünket könnyedén megtalálhassák egy igényes és szép weboldalon.
Szeretnénk nyilvántartásunkat online kezelni, hogy az ügyvezetők bárhonnan rá tudjanak nézni az aktuális információkra.

A weboldal könnyen üzemeltethető legyen, különböző szintű belépési rendszerrel (admin, user). Termékeket fel lehessen tölteni, módosítani, különböző kategóriákba besorolni.
A kategóriákat ugyanúgy lehessen bővíteni, szerkeszteni, törölni.
Kimutatásokat szeretnénk elérni az oldalon keresztül, illetve egy áttekinthető oldalt,ahol azonnal látjuk hány regisztrált ügyfelünk van, hány megrendelés és azok milyen státuszban vannak,
valamint hány termék van aktív, illetve törölt állapotban. 

Szeretnénk ha az ügyfelek a vásárolt termékekről véleményt is írhatnának(szöveges illetve csillagos értékelést egyaránt), de csak a megrendelt temékek kiszállítása után.
Természetesen az ügyfelek regisztrációt követően vissza tudják nézni a korábbi rendelésüket, valamint azok állapotát.


A fentiek alapján a fontosabb szempontok a következők:
- Weboldal és egyben webshop létrehozása
- Nyilvántartások online vezetése
- Külön szintű belépési rendszer létrehozása (admin, user)
- Termékek feltöltésének lehetősége, kategóriákba rendezése, kategóriák szerkesztése
- Kimutatások létrehozásának lehetősége (ügyfelek száma, megrendelések állapota, termékek elérhetősége)
- Felhasználói értékelési és véleményezési rendszer létrehozása




### 4. Jelenlegi üzleti folyamatok modellje

4.1.   Termékek egyesével való feltöltése különböző online értékesítési platformokra  
4.2.   Termékek rendelésének kezelése (telefonon vagy emailen keresztül)  
4.2.1. Rendelés felvitele az Excel táblázatban  
4.2.2. Rendelés összekészítése és csomagolása  
4.2.3. Rendelés futárral való kézbesítése  
4.2.4. Excel táblázat frissítése


### 5. Igényelt üzleti folyamatok modellje

5.1.   Termékek feltöltése a webshop felületére és adatbázisába
5.2.   Termékek rendelésének kezelése (weboldalon keresztül, megerősítő emaileken keresztül)
5.2.1. A felhasználó a kiválasztott terméket beteszi a kosarába, majd megrendeli
5.2.2. A rendelés részletei láthatóak lesznek az admin felületen
5.2.3. Rendelés összekészítése és csomagolása, megerősítő email elküldése
5.2.4. Rendelés futárral való kézbesítése
(5.3.  Adatbázis rendszer automatikus frissítése)

6.1. Saját webshop ahol az összes termék megtalálható  
6.2. Különböző szintű belépési lehetőség -> admin és user  
6.3 Különböző menük a jogokhoz  
  6.3.1. admin menü  
    6.3.1.1. termékek feltöltése, módosítása, törlése  
    6.3.1.2. kategóriák kezelése (hozzáadás, módosítás, törlés)  
    6.3.1.3. kimutatások megtekintése   
    6.3.1.4. rendelések kezelése  
    6.3.1.5. userek kezelése (törlés, módosítás)  
  6.3.2. user menü  
    6.3.2.1. rendelések megtekintése  
    6.3.2.2. satát profil megtekintése illetve módosítása (name, username, password)  
    6.3.2.3. kategóriák szerinti termék szűrés  
    6.3.2.4. kosár  
6.4. Megrendelt, illetve kiszállított termékekre az ügyfelek értékelést tudnak leadni  
6.5. Error page ha nem megfelelő oldalra téved az ügyfél

### 6. Követelménylista 



### 7. Használati esetek

A felhasználó jogosult a termékek kosárba tételére, címének hozzáadására, rendelése állapotának megfigyelésére. Illetve értékelni tudja a megvásárolt terméket, a kézhezkapás után.
Az admin jogosult a felhasználók kezelésére, törlésére. Rendelés állapotának módosítására. Termékek hozzáadására, eltávolítására. Vevői értékelések megtekintésre.

7.1. "User" felhasználói felület:
  6.1.1. A főoldalon jelenjenek meg a termékek kategóriákra bontva. A felhasználó tudjon böngészni ezen termékek között, lássa a termék leírását, értékeléseit, árát. 
  A vásárláshoz, illetve a kosárba helyezéshez bejelentkezés szükséges, amit a fejlécen található gombokkal tud megtenni. 
  Bejelentkezés után tudjon kosárba helyezni, onnan eltávolítani termékeket, tudjon vásárolni, lássa a korábbi rendeléseit, kézhezvételt követően tudjon értékelést írni.

7.2. "Admin" felhasználói felület:
  6.2.2. Bejelentkezés után az "User" felhasználói felülethez hasonlóan a főoldalon minden olyan információ megjelenik, amit a felhasználó is láthat.
    Láthassa, hogy milyen felhasználók vannak regisztrálva, legyen jogosult adatainak kezelésére, törlésére.
    Láthassa a rendelések állapotát, legyen jogosult ezen rendelések módosítására, törlésére.
    Láthassa, hogy milyen termékek vannak feltöltve az oldalra, láthassa ezek adatait, tudja módosítani, törölni, illetve új terméket hozzáadni.
    Vevői értékelések megtekintése, módosítása, törlése.

### 8. Képernyő tervek

Ki kell találnunk azt, amit látni szeretnénk a weblap oldalain, meg kell határozni a színeket, elemeket, képeket, animációkat etc. 
Figyelni kell rá, hogy a tartalomhoz harmonikusan illeszkedjen a megjelenés, messzemenően ügyelve a funkcionalitásra, hiszen egy webshopról van szó, amelyben a használhatóság rendkívül jelentős tényező. 
Képernyőterv: https://github.com/albachzsolt/AFP2021_1_LB_E_csoport/blob/main/wepshopplan.jpg


### 9. Forgatókönyvek

Mint ahogyan egy film esetében, a weblapnál is azt írja le a forgatókönyv, hogy mikor, mi történhet. 
A szereplők itt a nyomógombok, a jelenetek a lapok. 

Kezdőlap: A kezdő lapon található elemek közül a fejléc, a menüsor (menüpontok: kezdőlap, termékcsoportok, vásárlási feltételek, garancia, szállítás, kapcsolat), a weblap minden egyes oldalán megtalálhatóak lesznek. 
A menüsorban a termékcsoportra kattintva lenyílik a menü és megjelennek a termékcsoportok nevei.
Szállítás: egyszerű, statikus szöveg az állandó elemek mellett.
Termékek: Minden termékről látható legalább egy kép. Amennyiben több kép is található a rendszerben az adott termékről, akkor egy kis nyíl jelenik meg a kép mellett, amellyel léptetni lehet őket. 
Kosár (rendelés leadása): a kosárban lévő termékek miniatűr képpel és felirattal jelennek meg, mellettük egy szám, amely a rendelés mennyisége. Ezt a számot szabadon átírhatjuk. 
A megrendelés lépéseinél végig egyszerű űrlapok és szövegek jelenek meg.
Regisztráció: egy egyszerű űrlap áll a rendelkezésre. 


