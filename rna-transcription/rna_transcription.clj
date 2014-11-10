(ns rna-transcription)

(defn to-rna
  [sequence]
  {:pre [(every? #{\G \C \T \A} sequence)]}
  (let [complement (zipmap "GCTA" "CGAU")]
    (apply str (map complement sequence))))
