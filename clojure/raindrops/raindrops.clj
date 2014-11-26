(ns raindrops
  (:require [clojure.string :as str]))

(defn of [n]
  (loop [factors [] factor 2 current n]
    (cond
     (= n 1)                      []
     (= factor current)           (conj factors factor)
     (zero? (mod current factor)) (recur (conj factors factor) factor (quot current factor))
     :else                        (recur factors (inc factor) current))))

(defn pling-plang-plong [s]
  (let [pling (if (contains? s 3) "Pling" "")
        plang (if (contains? s 5) "Plang" "")
        plong (if (contains? s 7) "Plong" "")]
    (str pling plang plong)))

(defn convert [n]
  (let [factors (set (of n))
        ppp (pling-plang-plong factors)]
    (if (str/blank? ppp)
      (str n) ppp)))
