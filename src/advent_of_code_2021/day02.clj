(ns advent-of-code-2021.day02
  (:require [advent-of-code-2021.core :as core]))

(defn update-position-part-1 [line current-pos]
  (let [[direction amt-str] (clojure.string/split line #" ")
        amt (Integer/parseInt amt-str)]
    (condp = direction
      "forward" (update current-pos :x + amt)
      "up" (update current-pos :y - amt)
      "down" (update current-pos :y + amt))))


(defn calculate-position-part-1 [lines acc]
  (if (seq lines)
    (recur (rest lines) (update-position-part-1 (first lines) acc))
    acc))

(defn day2-part-1 [file-name]
  (let [file (core/read-input file-name)
        final-pos (calculate-position-part-1 (clojure.string/split-lines file) {:x 0 :y 0})]
    (* (:x final-pos) (:y final-pos))))


(defn update-position-part-2 [line current-pos]
  (let [[direction amt-str] (clojure.string/split line #" ")
        amt (Integer/parseInt amt-str)]
    (condp = direction
      "forward" (-> current-pos
                    (update :x + amt)
                    (update :y + (* amt (:aim current-pos))))
      "up" (update current-pos :aim - amt)
      "down" (update current-pos :aim + amt))))



(defn calculate-position-part-2 [lines acc]
  (if (seq lines)
    (recur (rest lines) (update-position-part-2 (first lines) acc))
    acc))


(defn day2-part-2 [file-name]
  (let [file (core/read-input file-name)
        final-pos (calculate-position-part-2 (clojure.string/split-lines file) {:x 0 :y 0 :aim 0})]
    (* (:x final-pos) (:y final-pos))))



(comment
  (day2-part-1 "day2-example.txt")
  (day2-part-1 "day2.txt")

  (day2-part-2 "day2-example.txt")
  (day2-part-2 "day2.txt")
)

