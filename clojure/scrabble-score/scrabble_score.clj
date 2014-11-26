(ns scrabble-score)

(def scores
  (into {} (concat
            (zipmap "AEIOULNRST" (repeat 1))
            (zipmap "DG"         (repeat 2))
            (zipmap "BCMP"       (repeat 3))
            (zipmap "FHVWY"      (repeat 4))
            (zipmap "K"          (repeat 5))
            (zipmap "JX"         (repeat 8))
            (zipmap "QZ"         (repeat 10)))))

(defmulti score-letter class)

(defmethod score-letter Character [letter]
  (scores (Character/toUpperCase letter)))

(defmethod score-letter String [letter]
  (score-letter (first letter)))

(defn score-word [word]
  (reduce + (map score-letter word)))
