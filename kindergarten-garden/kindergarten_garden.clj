(ns kindergarten-garden
  (:require [clojure.string :as str]))

(defn- ->key [name] (keyword (str/lower-case name)))

(def default-names
  ["Alice" "Bob" "Charlie"
   "David" "Eve" "Fred"
   "Ginny" "Harriet" "Ileana"
   "Joseph" "Kincaid" "Larry"])

(def plants
  (zipmap "VRCG" [:violets :radishes :clover :grass]))

(defn garden
  ([rows] (garden rows default-names))
  ([rows names]
     (let [people (map ->key (sort names))
           in-twos (partial partition 2)
           [first-row second-row] (str/split rows #"\n")
           joined (map concat (in-twos first-row) (in-twos second-row))
           planted (map #(map plants %) joined)]
       (zipmap people planted))))
