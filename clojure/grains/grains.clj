(ns grains)

(def grains (iterate #(* 2 %) 1N))

(defn square [x]
  (nth grains (dec x)))

(defn total []
  (dec (square 65)))
