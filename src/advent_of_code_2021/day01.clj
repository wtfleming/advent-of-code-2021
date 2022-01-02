(ns advent-of-code-2021.day01
  (:require [advent-of-code-2021.core :as core]))

(defn- num-increasing [input previous num-increased]
  (if (seq input)
    (let [increased? (> (first input) previous)]
      (if increased?
        (recur (rest input) (first input) (inc num-increased))
        (recur (rest input) (first input) num-increased)))
    num-increased))


(defn day1-part-1 [file-name]
  (let [input (core/input->int-seq file-name)]
    (num-increasing (rest input) (first input) 0)))


(defn day1-part-2 [file-name]
  (let [input (->> (core/input->int-seq file-name)
                   (partition 3 1) ; create a sliding window
                   (map #(apply + %)))] ; sum it
    (num-increasing (rest input) (first input) 0)))


(comment
  (day1-part-1 "day1-example.txt") ;; => 7
  (day1-part-1 "day1.txt")

  (day1-part-2 "day1-example.txt")
  (day1-part-2 "day1.txt")
)
