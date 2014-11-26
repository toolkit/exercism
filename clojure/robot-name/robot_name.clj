(ns robot-name)

(defn rand-str [length chars]
  (apply str (take length (repeatedly #(rand-nth chars)))))

(defn rand-name []
  (let [prefix (rand-str 2 "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
        suffix (rand-str 3 "0123456789")]
    (str prefix suffix)))

(defn robot []
  (atom (rand-name)))

(defn robot-name [r]
  (deref r))

(defn reset-name [r]
  (reset! r (rand-name)))
