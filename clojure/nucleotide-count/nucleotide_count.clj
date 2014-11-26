(ns nucleotide-count)

(defn nucleotide-counts [sequence]
  (let [empty (zipmap "CATG" (repeat 0))]
    (merge empty (frequencies sequence))))

(defn count [nucleotide sequence]
  (let [valid (set "CATGU")]
    (if (valid nucleotide)
      (get (nucleotide-counts sequence) nucleotide 0)
      (throw (Exception. "invalid nucleotide")))))
