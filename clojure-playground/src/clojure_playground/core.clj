(ns clojure-playground.core (:gen-class))

(use '[clojure.string :only (split triml)])

(with-in-str (slurp "D:\\Cygwin\\home\\Developer\\hack4fun\\clojure-playground\\src\\clojure_playground\\input.txt")

  (let [n (Integer/parseInt (read-line))
        s (into [] (into #{} (vec (map #(Integer/parseInt %) (split (read-line) #"\s+")))))
        m (Integer/parseInt (read-line))
        a (vec (map #(Integer/parseInt %) (split (read-line) #"\s+")))]
    (loop [s s
           a a]
      (if (empty? a)
        nil
        (let [new-s (loop [new-s s] (if (> (first a) (last s)) new-s (recur (butlast s))))]
          (println (inc (count new-s)))
          (recur new-s (rest a)))))))

;; (let [n (Integer/parseInt (read-line))
;;       s (vec (map #(Integer/parseInt %) (split (read-line) #"\s+")))
;;       m (Integer/parseInt (read-line))
;;       a (vec (map #(Integer/parseInt %) (split (read-line) #"\s+")))]
;;   (loop [s s
;;          a a]
;;     (if (empty? a)
;;       nil
;;       (let [rank 2]
;;         (println (inc (count (filter #(> % (first a)) (into #{} s)))))
;;         (recur s (rest a))))))
;; )
