(ns clojure-playground.core (:gen-class))

(use '[clojure.string :only (split triml)])

(defn readin []
;;  (with-in-str (slurp "D:\\Cygwin\\home\\Developer\\hack4fun\\clojure-playground\\src\\clojure_playground\\input.txt")
  (with-in-str "7\n100 100 50 40 40 20 10\n4\n5 25 50 120"
   ;; expected output: 6, 4, 2, 1

    (let [n (Integer/parseInt (read-line))
          s (into [] (sort > (into #{} (map #(Integer/parseInt %) (split (read-line) #"\s+")))))
          m (Integer/parseInt (read-line))
          a (vec (map #(Integer/parseInt %) (split (read-line) #"\s+")))]
      (println s)
      (println a)
      (loop [s s
             a a]
        (if (empty? a)
          nil
          (let [new-s (loop [new-s s] (if (> (last s) (first a)) new-s (recur (butlast s))))]
            (println (inc (count new-s)))
            (recur new-s (rest a))))))))

    ;; (loop [s s
    ;;        a a]
    ;;   (if (empty? a)
    ;;     nil
    ;;     (let [new-s (loop [new-s s] (if (> (last s) (first a)) new-s (recur (butlast s))))]
    ;;       (println (inc (count new-s)))
    ;;       (recur new-s (rest a)))))))

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
