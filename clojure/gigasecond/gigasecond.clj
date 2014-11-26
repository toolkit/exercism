(ns gigasecond
  (:require [clj-time.core :as t]))

(defn from [year month day]
  (let [date (t/local-date-time year month day)
        later (t/plus date (t/seconds 1000000000))]
    ((juxt t/year t/month t/day) later)))
