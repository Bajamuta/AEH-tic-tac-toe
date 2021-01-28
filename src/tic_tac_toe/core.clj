(ns tic-tac-toe.core)

(def tablica [1 2 3 4 5 6 7 8 9])
(def tab-gra [1 2 3 4 5 6 7 8 9])
(def tab2 [1 2 3 0 0 0 0 0 9])

(def runda1 (x))                                            ;;zapisz stan rundy1
(def runda2 (x))
(def runda3 (x))
(def runda4 (x))
(def runda5 (x))

(defn stan
  "Wypisz stan gry"
  [tab]
  (println (nth tab 0) "|" (nth tab 1) "|" (nth tab 2))
  (println "---------")
  (println (nth tab 3) "|" (nth tab 4) "|" (nth tab 5))
  (println "---------")
  (println (nth tab 6) "|" (nth tab 7) "|" (nth tab 8)))

(defn wolne
  "Sprawdź które pola są wolne; a to numer pola które wybrał użytkownik"
  [tab a]
  (filter some? (for [y (range 0 (count tab))]
    (if (not (= (- a 1) y))
      (if (= (nth tab y) (nth tablica y)) y))
    ))
  )

(defn losuj
  "Losuj gdzie komputer postawi X; a to numer pola które wybrał użytkownik"
  [tab a]
  ;;zwróć wylosowany numer pola, gdzie komputer postawi "X"
  (nth (wolne tab a) (rand-int (count (wolne tab a))))
  )

(defn nadpisz
  "Zaktualizuj tablicę gry, x to pozycja gracza, y to pozycja komputera"
  [x y tab]
  (for [z (range 0 (count tab))]
    (if (= z (- x 1)) "O" (if (= z (- y 1)) "X" (nth tab z))))
  )

(defn start
  "Rozpocznij grę"
  [x]
  ;;powitaj użytkownika
  ;;pokaż mu stan gry
  ;;poproś użytkownika o numer pola
  ;;nadpisz to pole znakiem "O"
  ;;pokaż użytkownikowi nowy stan
  (nadpisz x (losuj tablica x) tablica)
  )
