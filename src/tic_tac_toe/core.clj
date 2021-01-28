(ns tic-tac-toe.core)

(def tablica [1 2 3 4 5 6 7 8 9])
(def tab2 [1 2 3 0 0 0 0 0 0])

(defn stan
  "Wypisz stan gry"
  [tab]
  (println (nth tab 0) "|" (nth tab 1) "|" (nth tab 2))
  (println "---------")
  (println (nth tab 3) "|" (nth tab 4) "|" (nth tab 5))
  (println "---------")
  (println (nth tab 6) "|" (nth tab 7) "|" (nth tab 8)))

(defn wolne
  "Sprawdź które pola są wolne"
  [tab]
  (filter some? (for [y (range 0 (count tab))]
    (if-let [x (= (nth tab y) (nth tablica y))]
      y)
    ))
  )

(defn losuj
  "Losuj gdzie komputer postawi X"
  [tab]
  ;;zwróć wylosowany numer pola, gdzie komputer postawi "X"
  (nth (wolne tab) (rand-int (count (wolne tab))))
  )

(defn start
  "Rozpocznij grę"
  [x]
  ;;powitaj użytkownika
  ;;pokaż mu stan gry
  ;;poproś użytkownika o numer pola
  ;;nadpisz to pole znakiem "O"
  ;;pokaż użytkownikowi nowy stan
  )
