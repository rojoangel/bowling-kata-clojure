(ns bowling.core)

(defn- next-frame-spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn- next-frame-strike? [rolls]
  (= 10 (first rolls)))

(defn- game-ends-with-strike? [rolls]
  (= 2 (count (rest rolls))))

(defn- game-ends-with-spare? [rolls]
  (= 1 (count (drop 2 rolls))))

(defn- remaining-strike-rolls [rolls]
  (if (game-ends-with-strike? rolls)
    (drop 2 (rest rolls))
    (rest rolls)))

(defn- remaining-spare-rolls [rolls]
  (if (game-ends-with-spare? rolls)
    (drop 1 (drop 2 rolls))
    (drop 2 rolls)))

(defn- remaining-rolls [rolls]
  (drop 2 rolls))

(defn score [rolls]
  (if (empty? rolls)
    0
    (if (next-frame-strike? rolls)
      (+ (apply + (take 3 rolls))
         (score (remaining-strike-rolls rolls)))
      (if (next-frame-spare? rolls)
        (+ (apply + (take 3 rolls))
           (score (remaining-spare-rolls rolls)))
        (+ (apply + (take 2 rolls))
           (score (remaining-rolls rolls)))))))
