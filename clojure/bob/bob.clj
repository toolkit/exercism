(ns bob
  (:require [clojure.string :as str]))

(defn- question? [sentence]
  (.endsWith sentence "?"))

(defn- blank? [sentence]
  (str/blank? sentence))

(defn- shouting? [sentence]
  (and
   (= sentence (str/upper-case sentence))
   (re-find #"\p{Upper}" sentence)))

(defn response-for [sentence]
  (cond
   (blank? sentence)    "Fine. Be that way!"
   (shouting? sentence) "Whoa, chill out!"
   (question? sentence) "Sure."
   :else "Whatever."))
