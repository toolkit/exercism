(ns binary-search-tree)

(defn singleton [v] {:value v})

(defn left  [t] (:left t))
(defn right [t] (:right t))
(defn value [t] (:value t))

(defn insert [v t]
  (cond
   (nil? (:value t)) (assoc t :value v)
   (<= v (:value t)) (assoc t :left  (insert v (:left  t (singleton nil))))
   :else             (assoc t :right (insert v (:right t (singleton nil))))))

(defn from-list [vs]
  (reduce #(insert %2 %1) (singleton (first vs)) (rest vs)))

(defn to-list [t]
  (lazy-cat
   (when-not (nil? (:left t)) (to-list (:left t)))
   (vector (:value t))
   (when-not (nil? (:right t)) (to-list (:right t)))))
