(ns bowling.core)

(defn- next-frame-spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn- next-frame-strike? [rolls]
  (= 10 (first rolls)))

(defn- game-ends-with-strike? [rolls]
  (= 2 (count (rest rolls))))

(defn- game-ends-with-spare? [rolls]
  (= 1 (count (drop 2 rolls))))

(defmulti remaining-rolls (fn [rolls] (if (next-frame-strike? rolls) :strike)))

(defmethod remaining-rolls :strike [rolls]
  (if (game-ends-with-strike? rolls)
    (drop 2 (rest rolls))
    (rest rolls)))

(defn- remaining-spare-rolls [rolls]
  (if (game-ends-with-spare? rolls)
    (drop 1 (drop 2 rolls))
    (drop 2 rolls)))

(defmethod remaining-rolls nil [rolls]
  (drop 2 rolls))

(defn- score-strike-frame [rolls]
  (apply + (take 3 rolls)))

(defn- score-spare-frame [rolls]
  (apply + (take 3 rolls)))

(defn- score-frame [rolls]
  (apply + (take 2 rolls)))

(defn score [rolls]
  (if (empty? rolls)
    0
    (if (next-frame-strike? rolls)
      (+ (score-strike-frame rolls)
         (score (remaining-rolls rolls)))
      (if (next-frame-spare? rolls)
        (+ (score-spare-frame rolls)
           (score (remaining-spare-rolls rolls)))
        (+ (score-frame rolls)
           (score (remaining-rolls rolls)))))))
