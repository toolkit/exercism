(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn transform [input]
  (reduce
   (fn [outer [score items]]
     (reduce
      (fn [inner item]
        (assoc inner (lower-case item) score))
      outer items))
   {} input))
