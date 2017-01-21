(ns bowling.core)

(defn- spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn- strike? [rolls]
  (= 10 (first rolls)))

(defn- strike-bonus? [rolls]
  (= 2 (count rolls)))

(defn- spare-bonus? [rolls]
  (= 1 (count rolls)))

(defn score [rolls]
  (if (empty? rolls)
    0
    (if (strike? rolls)
      (+ (apply + (take 3 rolls))
         (if (strike-bonus? (rest rolls))
           0
           (score (rest rolls))))
      (if (spare? rolls)
        (+ (apply + (take 3 rolls))
           (if (spare-bonus? (drop 2 rolls))
             0
             (score (drop 2 rolls))))
        (+ (apply + (take 2 rolls)) (score (drop 2 rolls)))))))
