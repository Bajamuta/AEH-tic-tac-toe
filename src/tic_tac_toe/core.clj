(ns tic-tac-toe.core)

(def tablica [1 2 3 4 5 6 7 8 9])
(def tab-gra [1 2 3 4 5 6 7 8 9])
(def tab2 [1 2 3 0 0 0 0 0 9])

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
    (if (not (= a y))
      (if (= (nth tab y) (nth tablica y)) y)
      nil)
    ))
  )

(defn losuj
  "Losuj gdzie komputer postawi X; a to numer pola które wybrał użytkownik"
  [tab]
  ;;zwróć wylosowany index numeru pola, gdzie komputer postawi "X"
  (rand-int (count tab))
)

(defn komputer [tab x]
  (println "Komputer zagrał pole: " (+ x 1))
  (nth tab x))

(wolne tablica 2)
(rand-int (count (wolne tablica 2)))
(nth (wolne tablica 2) 4)

(defn nadpisz
  "Zaktualizuj tablicę gry, x to pozycja gracza, y to pozycja komputera"
  [x y tab]
  ;;(println x y)
  (if (not (= x y))
    (for [z (range 0 (count tab))]
      (do
        (if (= z x)
          "O"
          (if (= z y)
            "X"
            (nth tab z)))
        )
      )
    (println "Błąd"))
  )

(defn index [a]
  (- (Long/parseLong a) 1)
  )

(defn runda [a]
  (nadpisz a (komputer (wolne tablica a) (losuj (wolne tablica a))) tablica)
  )

(defn start
  "Rozpocznij grę"
  [x]
  ;;powitaj użytkownika
  ;;pokaż mu stan gry
  ;;poproś użytkownika o numer pola
  ;;nadpisz to pole znakiem "O"
  ;;pokaż użytkownikowi nowy stan
  (println "Podaj numer pola:")
  (stan (runda (index (do (flush) (read-line)))))
  )