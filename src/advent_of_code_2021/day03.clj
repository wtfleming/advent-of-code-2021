(ns advent-of-code-2021.day03
  (:require [advent-of-code-2021.core :as core]))

(defn gamma-rate [m]
  (->> m
       (mapv #(let [{zeroes :0, ones :1} %]
                (if (> zeroes ones) "0" "1")))
       clojure.string/join))

(defn epsilon-rate [m]
  (->> m
       (mapv #(let [{zeroes :0, ones :1} %]
                (if (> ones zeroes) "0" "1")))
       clojure.string/join))

(comment
  (gamma-rate [{:0 5, :1 7} {:0 7, :1 5} {:1 8, :0 4} {:0 5, :1 7} {:0 7, :1 5}])
  ;; => "10110"

  (epsilon-rate [{:0 5, :1 7} {:0 7, :1 5} {:1 8, :0 4} {:0 5, :1 7} {:0 7, :1 5}])
  ;; => "01001"
  )

(defn transpose
  "Transpose a matrix. See https://stackoverflow.com/questions/10347315/matrix-transposition-in-clojure/10347404"
  [m]
  (apply mapv vector m))

(defn lines->matrix [lines]
  (->> lines
       (mapv #(clojure.string/split % #""))
       (mapv #(mapv str %))
       (mapv #(mapv keyword %))))

(defn day3-part-1 [file-name]
  (let [file (core/read-input file-name)
        lines (clojure.string/split-lines file)
        matrix (lines->matrix lines)
        matrix-transposed (transpose matrix)
        with-freqs (mapv frequencies matrix-transposed)
        gamma (Integer/parseInt (gamma-rate with-freqs) 2)
        epsilon (Integer/parseInt (epsilon-rate with-freqs) 2)
        power-consumption (* gamma epsilon)]
    power-consumption
    ))


(comment
  (day3-part-1 "day3-example.txt")
  (day3-part-1 "day3.txt")
)
