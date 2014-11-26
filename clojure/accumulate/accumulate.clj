(ns accumulate)

(defn accumulate [f coll]
  (loop [accum [] c coll]
    (if (seq c)
      (recur (conj accum (f (first c))) (rest c))
      accum)))
