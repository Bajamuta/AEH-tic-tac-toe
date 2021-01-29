(ns tic-tac-toe.core)

(def tablica [1 2 3 4 5 6 7 8 9])
(def tab-gra [1 2 3 4 5 6 7 8 9])
(def tab2 [0 0 3 0 0 0 0 0 0])
(def tab3 ["O" "O" "O" 4 "X" 6 "X" "X" 9])

(defn stan
  "Wypisz stan gry"
  [tab]
  (println " ")
  (println (nth tab 0) "|" (nth tab 1) "|" (nth tab 2))
  (println "---------")
  (println (nth tab 3) "|" (nth tab 4) "|" (nth tab 5))
  (println "---------")
  (println (nth tab 6) "|" (nth tab 7) "|" (nth tab 8))
  (println " ")
  )

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
  (println "Komputer zagrał pole: " (+ (nth tab x) 1))
  (nth tab x))

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

(defn runda [a tab]
  (if (> (count (wolne tab a)) 0)
    (nadpisz a (komputer (wolne tab a) (losuj (wolne tab a))) tab)
    (nadpisz a nil tab)
    )
  )

(defn sprawdz
  "Sprawdź czy ktoś już wygrał"
  [tab]
  (filter true? (list (= (nth tab 0) (nth tab 1) (nth tab 2))
                (= (nth tab 0) (nth tab 4) (nth tab 8))
                (= (nth tab 0) (nth tab 3) (nth tab 6))
                (= (nth tab 1) (nth tab 4) (nth tab 7))
                (= (nth tab 3) (nth tab 5) (nth tab 8))
                (= (nth tab 3) (nth tab 4) (nth tab 5))
                (= (nth tab 6) (nth tab 7) (nth tab 8))
                (= (nth tab 2) (nth tab 4) (nth tab 6))))
  )

(defn graj [tab]
  (if (not (nil? tab))
    (do
      (println "Podaj numer pola:")
      (let [x (runda (index (do (flush) (read-line))) tab)]
        (stan x)
        (if (first (sprawdz x))
          (do (println "Wygrana!") nil)
          (do (println "Dalej") x))
        ;;x
        )
      )
    )
  )

(defn start
  "Rozpocznij grę"
  []
  ;;powitaj użytkownika
  ;;pokaż mu stan gry
  ;;poproś użytkownika o numer pola
  ;;wylosuj pole komputera
  ;;pokaż użytkownikowi nowy stan
  ;;powtórz aż wszystkie pola zapełnione
  (println "Witamy w grze Kółko Krzyżyk!")
  (stan tablica)
  (graj (graj (graj (graj (graj tablica)))))
  (println "Koniec gry!")
  )