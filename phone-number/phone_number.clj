(ns phone-number)

(defn number [phone-number]
  (let [cleaned (apply str (re-seq #"\d" phone-number))]
    (cond
     (= (count cleaned) 10) cleaned
     (and (= (count cleaned) 11) (= \1 (first cleaned))) (subs cleaned 1)
     :else "0000000000")))

(defn area-code [phone-number]
  (let [num (number phone-number)]
    (subs num 0 3)))

(defn pretty-print [phone-number]
  (let [num (number phone-number)
        area-code (subs num 0 3)
        prefix    (subs num 3 6)
        suffix    (subs num 6)]
    (format "(%s) %s-%s" area-code prefix suffix)))
