(ns advent-of-code-2021.day02
  (:require [advent-of-code-2021.core :as core]))

(defn update-position [line current-pos]
  (let [[direction amt-str] (clojure.string/split line #" ")
        amt (Integer/parseInt amt-str)]
    (condp = direction
      "forward" (update current-pos :x + amt)
      "up" (update current-pos :y - amt)
      "down" (update current-pos :y + amt))))


(defn calculate-position [lines acc]
  (if (seq lines)
    (recur (rest lines) (update-position (first lines) acc))
    acc))

(defn day2-part-1 [file-name]
  (let [file (core/read-input file-name)
        final-pos (calculate-position (clojure.string/split-lines file) {:x 0 :y 0})]
    (* (:x final-pos) (:y final-pos))))



(comment
  (day2-part-1 "day2-example.txt")
  (day2-part-1 "day2.txt")

)

