(ns advent-of-code-2021.core)

(defn read-input
  [file-name]
  (slurp (clojure.java.io/resource file-name)))

(defn input->int-seq
  [file-name]
  (->> (clojure.java.io/resource file-name)
       slurp
       clojure.string/split-lines
       (map #(Integer/parseInt %))))

