(ns space-age)

(defn on-planet [conversion]
  (fn ^double [seconds] (/ seconds conversion)))

(def on-mercury (on-planet 7600543.81992))
(def on-venus   (on-planet 1.9414149052176E7))
(def on-earth   (on-planet 31557600))
(def on-mars    (on-planet 5.9354032690079994E7))
(def on-jupiter (on-planet 3.74355659124E8))
(def on-saturn  (on-planet 9.292923628848E8))
(def on-uranus  (on-planet 2.6513700193296E9))
(def on-neptune (on-planet 5.200418560032001E9))
