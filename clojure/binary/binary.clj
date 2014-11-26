(ns binary)

(defmulti to-decimal class)

(defmethod to-decimal Character [c]
  (case c \0 0 \1 1 (throw (Exception. "invalid character"))))

(defmethod to-decimal String [s]
  (try 
    (reduce (fn [res bit] (+ (* 2 res) bit)) 0 (map to-decimal s))
    (catch Exception e 0)))
