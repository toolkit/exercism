(ns queen-attack
  (:require [clojure.pprint :refer [pprint]]
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

(defn can-attack [queens]
  (let [board (empty-board 8)
        board (update-board board queens)
        row-sets (map set board)
        col-sets (map set (apply map vector board))]
    nil))

(defn row-sets [board]
  (map set board))

(defn column-sets [board]
  (map set (apply map vector board)))

(def test-board
  [[000 001 002 003 004 005 006 007]
   [010 011 012 013 014 015 016 017]
   [020 021 022 023 024 025 026 027]
   [030 031 032 033 034 035 036 037]
   [040 041 042 043 044 045 046 047]
   [050 051 052 043 054 055 056 057]
   [060 061 062 043 064 065 066 067]
   [070 071 072 043 074 075 076 077]])

(row-sets test-board)
(column-sets test-board)
(right-diagonals test-board)
