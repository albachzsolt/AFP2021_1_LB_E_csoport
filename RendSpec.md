# Rendszerspecifikáció

A követelmény specifikációban megfogalmazott feladatok elkészítés több ütemben készül el.

## A rendszerrel szemben támasztott általános követelmények

- A rendszer egyes funkcióit csak bejelentkezett felhasználó használhatja.
- Frontend HTML/JS/CSS.
- Backend Java nyelven írodjon, SprinBoot használatával.
- Adattárolás MySQL adatbáziban.

## Az alkalmazásokkal szemben támasztott funkcionális követelmények

- Felhasználókezelés
  - Admin
   - User

## Funkcionális követelmények

### Admin által elérhető funkciók

- webes felületen keresztül elérhető funkciók:
    - termékek feltöltése, módosítása, törlése
    - kategóriák kezelése (hozzáadás, módosítás, törlés)
    - kimutatások megtekintése
    - rendelések kezelése
    - userek kezelése (törlés, módosítás)

### User által elérhető funkciók

- webes felületen keresztül elérhető funkciók:
    - rendelések megtekintése
    - satát profil megtekintése illetve módosítása (name, username, password)
    - kategóriák szerinti termék szűrés
    - kosár

## Adatbázis terv
Karakterkódolás UTF8. Tábla és mezőneveknél snake_case konvenciót alkalmazunk. 
- PK - alapból auto increment, ha más nincs megadva. 
- mezők - ahol nincs megadva, ott az alapparaméterek: null 
- FK - kapcsoló mezők konvenciója: fk_X_Y, ahol X az alaptábla és Y a kapcsolt tábla
- zárójelben az alapértelmezett érték

#### Táblák:

- Termék tábla
	- táblanév: products
	- mező nevek: 
		- id, PK
		- code, UQ
		- name, UQ
		- address, UQ
		- manufacturer
		- price, not null
		- status, (ACTIVE)
		- category_id, (1), fk_products_categories

- Ügyfél tábla
	- táblanév: users
	- mezők neve:
		- id, PK
		- first_name
		- last_name
		- username, UQ
		- password
		- role
		- enabled

- Kosár tábla
	- táblanév: baskets
	- mezők neve:
		- id, PK
		- user_id, UQ, fk_baskets_users

- Kosár tartalom tábla:
	- táblanév: basket_items
	- mezők neve:
		- basket_id, fk_basket_items_baskets
		- product_id, fk_basket_items_products
		- quantity

- Megrendelés tábla:
	- táblanév: orders
	- mezők neve: 
		- id, PK
		- user_id, fk_orders_users
		- order_time
		- status
		- shipping_address

- Megrendelt termékek tábla
	- táblanév: ordered_items
	- mezők neve:
		- order_id, fk_ordered_items_baskets
		- product_id, fk_ordered_items_products
		- order_price
		- quantity

- Kategóriák tábla
	- táblanév: categories
	- mezők neve:
		- id, PK
		- name
		- sequence

- Értékelés tábla
	- táblanév: ratings
	- mezők neve:
		- id, PK
		- user_id, fk_ratings_users
		- product_id, fk_ratings_products
		- stars
		- message
		- rating_time
