(ns clojure-playground.core (:gen-class))

(use '[clojure.string :only (split triml)])
;; 2998
(defn testing []
(with-in-str "1 2000000 1000000000"
(let [[i j k] (map #(Integer/parseInt %) (split (read-line) #"\s+"))
      c       (loop [i i c 0] (if (> i j) c
                                  (let [r (Long/parseLong (apply str (reverse (str i))))
                                        d (Math/abs (- i r))]
                                    (recur (inc i)
                                           (if (zero? (rem d k)) (inc c) c)))))]
  (println c))))
;; (with-in-str "1 2000000 1000000000"
;; (let [[i j k] (map #(Integer/parseInt %) (split (read-line) #"\s+"))
;;       c       (doall (loop [i i c 0] (if (> i j) c
;;                                          (let [r (Integer/parseInt (apply str (reverse (str i))))
;;                                                d (Math/abs (- i r))]
;;                                            (recur (inc i)
;;                                                   (if (zero? (rem d k)) (inc c) c))))))]
;;   (println c)))
