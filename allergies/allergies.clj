(ns allergies)

(def allergies
  {1 "eggs"
   2 "peanuts"
   4 "shellfish"
   8 "strawberries"
   16 "tomatoes"
   32 "chocolate"
   64 "pollen"
   128 "cats"})

(defn list [score]
  (for [b (range 8)
        :let [v (bit-shift-left 1 b)]
        :when (not (zero? (bit-and v score)))]
    (allergies v)))

(defn allergic_to? [score allergen]
  (contains? (set (list score)) allergen))
