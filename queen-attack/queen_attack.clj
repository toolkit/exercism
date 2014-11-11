(ns queen-attack
  (:require [clojure.set :refer [subset?]]
            [clojure.pprint :refer [pprint]]
            [clojure.string :refer [join]]))

(defn empty-board [size]
  (vec (repeat size (vec (repeat size "O")))))

(defn update-board [board {:keys [w b]}]
  (if (or (nil? w) (nil? b))
    board
    (-> board (assoc-in w "W") (assoc-in b "B"))))

(defn to-str [board]
  (str (join "\n" (map #(join " " %) board)) "\n"))

(defn board-string [queens]
  (let [board (empty-board 8)
        board (update-board board queens)]
    (to-str board)))

(defn rows [board]
  (map #(apply sorted-set %) board))

(defn columns [board]
  (map #(apply sorted-set %) (apply map vector board)))

(defn diagonal
  "Return a sequence of [x y] coords. These may go outside the board's dimensions
  It is the responsibility of a subsequent get-in call to fill in nils for the
  invalid coordinates, and then use set membership to determine if a diagonal
  contains both W and B"
  [y step size]
  (take size (iterate (fn [[x y]] [(inc x) (+ step y)]) [0 y])))

(defn diagonals [board]
  (let [size (count board)]
    (for [step [1 -1] y (range (- size) (* size 2))]
      (apply sorted-set (map #(get-in board % nil) (diagonal y step size))))))

(defn can-attack? [s]
  (subset? #{"W" "B"} s))

(defn can-attack [queens]
  (let [board (empty-board 8)
        board (update-board board queens)
        sets (concat (rows board) (columns board) (diagonals board))]
    (not (nil? (some can-attack? sets)))))

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
