(ns hexadecimal)

(def hex (zipmap "0123456789abcdef" (range 0 16)))

(defn hex-to-int [s]
  (try
    (reduce #(+ (* 16 %1) (hex %2)) 0 s)
    (catch NullPointerException e 0)))
