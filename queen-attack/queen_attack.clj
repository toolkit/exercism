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
