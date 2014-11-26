(ns word-count
  (:require [clojure.string :as str]))

(defn word-count [sentence]
  (frequencies (re-seq #"\p{Alnum}+" (str/lower-case sentence))))
