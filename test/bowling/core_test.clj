(ns bowling.core-test
  (:use midje.sweet)
  (:use [bowling.core]))


(facts "about bowling score"
  (fact "it scores a game with all zeroes"
        (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]) => 0))
