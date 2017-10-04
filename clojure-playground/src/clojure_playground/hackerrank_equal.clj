(ns clojure-playground.core (:gen-class))

(use '[clojure.string :only (split triml)])

(def input-file "/Users/tosch/CLOJOY/playground/myinput.txt")

(defn solution []

  (let [num-testcases (Integer/parseInt (read-line))
        costs         (vec (flatten (take 201 (iterate #(map inc %) '(0 1 1 2 2)))))]

    (loop [a0 num-testcases]
      (when (> a0 0)

        (let [num-colleagues (Integer/parseInt (read-line))
              cnoc           (map #(Integer/parseInt %) (split (read-line) #"\s+"))
              minc           (apply min cnoc)
              cost-arr       (loop [rcnoc cnoc
                                    cost1 0
                                    cost2 0
                                    cost3 0]
                               (if (empty? rcnoc)
                                 (list cost1 cost2 cost3)
                                 (recur (rest rcnoc)
                                        (+ cost1 (costs (- (first rcnoc) minc)))
                                        (+ cost2 (costs (- (inc (first rcnoc)) minc)))
                                        (+ cost3 (costs (- (+ 2 (first rcnoc)) minc))))))]

          (println (apply min cost-arr)))

        (recur (dec a0))))))

(defn solve []
  (with-in-str (slurp input-file) (solution)))

(defn -main [& args]
  (solve))
