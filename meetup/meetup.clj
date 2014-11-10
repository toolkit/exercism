(ns meetup
  (:require [clj-time.core :as t]))

(defn to-vec [date]
  ((juxt t/year t/month t/day) date))

(defn dates-for [year month]
  (let [end (-> (t/last-day-of-the-month year month)
                (t/day)
                inc)]
    (map #(t/local-date year month %) (range 1 end))))

(defn day-of-week [date]
  ([nil :monday :tuesday :wednesday :thursday :friday :saturday :sunday]
   (t/day-of-week date)))

(defn teenth? [date]
  (let [[_ _ dom] (to-vec date)]
    (< 12 dom 20)))

(defn teenth [dates]
  (->> dates
      (drop-while #(not (teenth? %)))
      first))

(def positions
  {:first first
   :second second
   :third #(nth % 2)
   :fourth #(nth % 3)
   :last last
   :teenth teenth})

(defn meetup [month year dow pos]
  (let [position (positions pos)]
    (->> (dates-for year month)
         (keep #(if (= dow (day-of-week %)) %))
         position
         to-vec)))
