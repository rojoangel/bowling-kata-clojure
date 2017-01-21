(ns bowling.core-test
  (:use midje.sweet)
  (:use [bowling.core]))

(let [a-gutter-game [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
  (facts "about bowling score"
         (fact "it scores a gutter game"
               (score a-gutter-game) => 0)))
