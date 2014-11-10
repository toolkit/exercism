(ns anagram
  (:require [clojure.string :as str]))

(defn anagram? [word candidate]
  (let [lc-word (str/lower-case word)
        lc-candidate (str/lower-case candidate)]
    (and (not (= lc-word lc-candidate))
         (= (sort lc-word) (sort lc-candidate)))))

(defn anagrams-for [word candidates]
  (filter #(anagram? word %) candidates))
