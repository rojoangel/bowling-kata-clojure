(ns bowling.core)

(defn spare? [roll1 roll2]
  (= 10 (+ roll1 roll2)))

(defn strike? [roll]
  (= 10 roll))

(defn score [rolls]
  (if (strike? (first rolls))
    (+ (apply + (take 3 rolls)) (score (rest rolls)))
    (if (spare? (first rolls) (second rolls))
      (+ (apply + (take 3 rolls)) (score (drop 2 rolls)))
      (apply + rolls))))
