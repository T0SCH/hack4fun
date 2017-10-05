(ns clojure-playground.core (:gen-class))

(use '[clojure.string :only (split triml)])

(defn get-seq-length [s pos]
  (if (or (< pos 0) (> (inc pos) (count s))) -1
      (let [curpos (loop [curpos pos]
                     (if (and (< (inc curpos) (count s)) (= (get s curpos) (get s (inc curpos))))
                       (recur (inc curpos))
                       curpos))]
        (inc (- curpos pos)))))

(defn is-seq? [s pos] (> (get-seq-length s pos) pos))

(defn is-wrapped-seq? [s pos]
  (let [seq-length (get-seq-length s pos)]
    (if (or (zero? pos)
            (<= (- (count s) (inc pos)) 1)
            (< seq-length 2)
            (> seq-length (count s)))
      false
      (and (not (= (get s (dec pos)) (get s pos)))
           (= (get s (dec pos)) (get s (+ pos seq-length)))))))


;; bool wSeqFound = false;
;; do {
;;     wSeqFound = false;
;;     for( int i = 1; i < s.length() - 2; ++i ) {
;;         if (isWrappedSeq(s, i)) {
;;                                  s = s.mid(0, i) + s.mid(i+getSeqLength(s, i));
;;                                  wSeqFound = true;
;;                                  break;
;;                                  }
;;         }
;;     } while (wSeqFound);

;; bool seqFound = false;
;; do {
;;     seqFound = false;
;;     for ( int i = 0; i < s.length() - 1; ++i ) {
;;          if (getSeqLength(s, i)>1) {
;;                                     s = s.mid(0, i) + s.mid(i+getSeqLength(s, i));
;;                                     seqFound = true;
;;                                     break;
;;                                     }
;;          }
;;     } while (seqFound);
