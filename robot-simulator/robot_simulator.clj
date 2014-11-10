(ns robot-simulator)

(defn robot [coordinates bearing]
  {:bearing bearing :coordinates coordinates})

(defn turn-right [bearing]
  (case bearing
    :north :east
    :east  :south
    :south :west
    :west  :north))

(defn turn-left [bearing]
  (case bearing
    :north :west
    :east  :north
    :south :east
    :west  :south))

(defn advance [{:keys [bearing coordinates] :as robot}]
  (update-in robot [:coordinates]
             (fn [{:keys [x y]}]
               (case bearing
                 :north {:x x :y (inc y)}
                 :east  {:x (inc x) :y y}
                 :south {:x x :y (dec y)}
                 :west  {:x (dec x) :y y}))))

(defn simulate [steps robot]
  (reduce (fn [robot step]
            (case step
              \R (update-in robot [:bearing] turn-right)
              \L (update-in robot [:bearing] turn-left)
              \A (advance robot))) robot steps))
