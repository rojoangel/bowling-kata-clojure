(ns bowling.core)

(defn score [rolls]
  (apply + rolls))
