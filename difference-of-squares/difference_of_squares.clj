(ns difference-of-squares)

(defn- sum [n]
  (/ (* n (+ n 1)) 2))

(defn square-of-sums [n]
  (let [s (sum n)] (* s s)))

(defn sum-of-squares
  "Take a look at http://mathforum.org/library/drmath/view/56920.html"
  [n]
  (/ (* n (+ n 1) (+ (* 2 n) 1)) 6))

(defn difference [n]
  (- (square-of-sums n) (sum-of-squares n)))
