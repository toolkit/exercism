(ns largest-series-product)

(defn digits [s]
  (map (zipmap "0123456789" (range)) s))

(defn slices [n s]
  (partition n 1 (digits s)))

(defn largest-product [n s]
  (cond
   (= 0 n)         1
   (> n (count s)) 1
   :else (reduce max (map #(apply * %) (slices n s)))))
