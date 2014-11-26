(ns queen-attack
  (:require [clojure.pprint :refer [pprint]]
            [clojure.string :refer [join]]))

(defn empty-board [size]
  (vec (repeat size (vec (repeat size "O")))))

(defn set-position [board position piece]
  (if position
    (assoc-in board position piece)
    board))

(defn to-str [board]
  (str (join "\n" (map #(join " " %) board)) "\n"))

(defn board-string [{:keys [w b]}]
  (-> (empty-board 8)
      (set-position w "W")
      (set-position b "B")
      to-str))

(defn can-attack [{[wx wy] :w [bx by] :b}]
  (let [dx (- bx wx)
        dy (- by wy)]
    (or (zero? dx)
        (zero? dy)
        (= (* dx dx) (* dy dy)))))

;; x is top (0) to bottom, y is left (0) to right
(def test-board
  [["AA" "AB" "AC" "AD" "AE" "AF" "AG" "AH"]
   ["BA" "BB" "BC" "BD" "BE" "BF" "BG" "BH"]
   ["CA" "CB" "CC" "CD" "CE" "CF" "CG" "CH"]
   ["DA" "DB" "DC" "DD" "DE" "DF" "DG" "DH"]
   ["EA" "EB" "EC" "ED" "EE" "EF" "EG" "EH"]
   ["FA" "FB" "FC" "FD" "FE" "FF" "FG" "FH"]
   ["GA" "GB" "GC" "GD" "GE" "GF" "GG" "GH"]
   ["HA" "HB" "HC" "HD" "HE" "HF" "HG" "HH"]])
