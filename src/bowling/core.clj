(ns bowling.core)

(defn spare? [roll1 roll2]
  (= 10 (+ roll1 roll2)))

(defn strike? [roll]
  (= 10 roll))

(defn strike-bonus? [rolls]
  (= 2 (count rolls)))

(defn spare-bonus? [rolls]
  (= 1 (count rolls)))

(defn score [rolls]
  (if (strike? (first rolls))
    (+ (apply + (take 3 rolls))
       (if (strike-bonus? (rest rolls))
         0
         (score (rest rolls))))
    (if (spare? (first rolls) (second rolls))
      (+ (apply + (take 3 rolls))
         (if (spare-bonus? (drop 2 rolls))
           0
           (score (drop 2 rolls))))
      (apply + rolls))))
