(ns bowling.core)

(defn- next-frame-spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn- next-frame-strike? [rolls]
  (= 10 (first rolls)))

(defn- game-ends-with-strike? [rolls]
  (= 2 (count (rest rolls))))

(defn- game-ends-with-spare? [rolls]
  (= 1 (count (drop 2 rolls))))

(defn score [rolls]
  (if (empty? rolls)
    0
    (if (next-frame-strike? rolls)
      (+ (apply + (take 3 rolls))
         (if (game-ends-with-strike? rolls)
           (score (drop 2 (rest rolls)))
           (score (rest rolls))))
      (if (next-frame-spare? rolls)
        (+ (apply + (take 3 rolls))
           (if (game-ends-with-spare? rolls)
             (score (drop 1 (drop 2 rolls)))
             (score (drop 2 rolls))))
        (+ (apply + (take 2 rolls)) (score (drop 2 rolls)))))))
