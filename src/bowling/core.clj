(ns bowling.core)

(defn- next-frame-spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn- next-frame-strike? [rolls]
  (= 10 (first rolls)))

(defn- game-ends-with-strike? [rolls]
  (= 2 (count (rest rolls))))

(defn- game-ends-with-spare? [rolls]
  (= 1 (count (drop 2 rolls))))

(defmulti remaining-rolls (fn [rolls] (if (next-frame-strike? rolls)
                                        :strike
                                        (if (next-frame-spare? rolls)
                                          :spare))))

(defmethod remaining-rolls :strike [rolls]
  (if (game-ends-with-strike? rolls)
    (drop 2 (rest rolls))
    (rest rolls)))

(defmethod remaining-rolls :spare [rolls]
  (if (game-ends-with-spare? rolls)
    (drop 1 (drop 2 rolls))
    (drop 2 rolls)))

(defmethod remaining-rolls nil [rolls]
  (drop 2 rolls))

(defmulti score-frame (fn [rolls] (if (next-frame-strike? rolls)
                                    :strike
                                    (if (next-frame-spare? rolls)
                                      :spare))))


(defmethod score-frame :strike [rolls]
  (apply + (take 3 rolls)))

(defmethod score-frame :spare [rolls]
  (apply + (take 3 rolls)))

(defmethod score-frame nil [rolls]
  (apply + (take 2 rolls)))

(defn score [rolls]
  (if (empty? rolls)
    0
    (if (next-frame-strike? rolls)
      (+ (score-frame rolls)
         (score (remaining-rolls rolls)))
      (if (next-frame-spare? rolls)
        (+ (score-frame rolls)
           (score (remaining-rolls rolls)))
        (+ (score-frame rolls)
           (score (remaining-rolls rolls)))))))
