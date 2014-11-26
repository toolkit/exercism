(ns crypto-square
  (:require [clojure.string :refer [lower-case join]]))

(defn normalize-plaintext [plaintext]
  (apply str (re-seq #"\p{Alnum}" (lower-case plaintext))))

(defn square-size [string]
  (int (Math/ceil (Math/sqrt (count string)))))

(defn plaintext-segments [plaintext]
  (let [plaintext (normalize-plaintext plaintext)
        size (square-size plaintext)]
    (map #(apply str %) (partition-all size plaintext))))

(defn- pad-nil [segments]
  (let [pad-size (count segments)]
    (map #(concat (vec %) (repeat pad-size nil)) segments)))

(defn ciphertext [plaintext]
  (let [segments (plaintext-segments plaintext)
        padded (pad-nil segments)]
    (apply str (apply interleave padded))))

(defn normalize-ciphertext
  "Doesn't seem to work for last unit test. Hmm"
  [plaintext]
  (let [ciphertext (ciphertext plaintext)
        size (int (Math/ceil (/ (count ciphertext) (square-size ciphertext))))]
    (join " " (map #(apply str %) (partition-all size ciphertext)))))
