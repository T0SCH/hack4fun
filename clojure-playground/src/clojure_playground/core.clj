(ns clojure-playground.core (:gen-class))

(def input-file "D:\\Cygwin\\home\\Developer\\hack4fun\\clojure-playground\\myinput.txt")

(use '[clojure.string :only (split triml)])

(defn solution []

  (let [num-testcases (Integer/parseInt (read-line))
        costs         (vec (flatten (take 200 (iterate #(map inc %) '(0 1 1 2 2)))))]

    (loop [a0 num-testcases]
      (when (> a0 0)

        (let [num-colleagues (Integer/parseInt (read-line))
              cnoc           (map #(Integer/parseInt %) (split (read-line) #"\s+"))
              min            (apply min cnoc)
              cost           (loop [rcnoc cnoc
                                    cost  0]
                               (if (empty? rcnoc)
                                 cost
                                 (recur (rest rcnoc)
                                        (+ cost (costs (- (first rcnoc) min))))))]
          (println cost))
        (recur (dec a0))))))

(defn solve []
  (with-in-str (slurp input-file) (solution)))

(defn -main [& args]
  (solve)
  (println "DONE!"))
