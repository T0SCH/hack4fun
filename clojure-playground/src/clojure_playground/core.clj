(ns clojure-playground.core (:gen-class))

(use '[clojure.string :only (split triml)])

(defn is-kaprekar? [n]
  (let [s (str (* n n))]
    (pos? (count (filter #(= n (+ (Integer/parseInt (first %)) (Integer/parseInt (second %))))
                    (for [x (range 1 (count s))] (list (subs s 0 x) (subs s x))))))))

(with-in-str "1\n100"
(let [p (Integer/parseInt (read-line))
      q (Integer/parseInt (read-line))
      nums (filter #(is-kaprekar? %) (range p (inc q)))]
  (println (apply str (interpose " " nums)))))
