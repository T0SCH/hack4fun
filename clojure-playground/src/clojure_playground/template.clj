(ns clojure-playground.core (:gen-class))

(use '[clojure.string :only (split triml)])

(def input-file  "/Users/tosch/hack4fun/clojure-playground/input.txt")
(def output-file "/Users/tosch/hack4fun/clojure-playground/output.txt")

(defn solution []

  (let [T (Integer/parseInt (read-line))]

    (loop [a0 T]
      (when (> a0 0)

        (let [N   (Integer/parseInt (read-line))
              arr (map #(Integer/parseInt %) (split (read-line) #"\s+"))]

          (println "Result="))

        (recur (dec a0))))))

(defn solve []
  (with-in-str (slurp input-file) (solution)))

(defn -main [& args]
  (solve))
