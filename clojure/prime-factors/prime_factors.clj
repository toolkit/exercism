(ns prime-factors)

(defn of [n]
  (loop [factors [] factor 2 current n]
    (cond
     (= n 1)                      []
     (= factor current)           (conj factors factor)
     (zero? (mod current factor)) (recur (conj factors factor) factor (quot current factor))
     :else                        (recur factors (inc factor) current))))
