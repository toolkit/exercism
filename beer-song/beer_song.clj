(ns beer-song
  (:require [clojure.string :as s]))

(defn pluralize [n]
  (case n
    1 (str n " bottle of beer")
    0 "no more bottles of beer"
    (str n " bottles of beer")))

(defn action [before]
  (let [after (pluralize (mod (+ (dec before) 100) 100))]
    (case before
      1 (str "Take it down and pass it around, " after " on the wall.\n")
      0 (str "Go to the store and buy some more, " after " on the wall.\n")
      (str "Take one down and pass it around, " after " on the wall.\n"))))

(defn verse [n]
  (let [p (pluralize n)
        first-line (s/capitalize (str p " on the wall, " p ".\n"))
        action-line (action n)]
    (str first-line action-line)))

(defn sing
  ([from] (sing from 0))
  ([from to] (s/join "\n" (map verse (range from (dec to) -1)))))
