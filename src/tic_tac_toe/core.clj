(ns tic-tac-toe.core)

(defn stan
  "Wypisz stan gry"
  [x y]
  (println x "|" x "|" x)
  (println "---------")
  (println y "|" x "|" y)
  (println "---------")
  (println "7" "|" "8" "|" "9"))
