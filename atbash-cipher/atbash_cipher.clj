(ns atbash-cipher
  (:require [clojure.string :as str]))

(defn encode [plaintext]
  (let [alphabet "abcdefghijklmnopqrstuvwxyz"
        digits "0123456789"
        encryption (merge (zipmap alphabet (reverse alphabet)) (zipmap digits digits))
        filtered (filter #(Character/isLetterOrDigit %) (str/lower-case plaintext))
        encrypted (map encryption filtered)
        with-spaces (str/join " " (map #(apply str %) (partition-all 5 encrypted)))]
    with-spaces))
