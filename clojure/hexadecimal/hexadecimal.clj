(ns hexadecimal)

(def hex (zipmap "0123456789abcdef" (range)))

(defn hex-to-int [s]
  (try
    (reduce #(+ (* 16 %1) (hex %2)) 0 s)
    (catch NullPointerException e 0)))
