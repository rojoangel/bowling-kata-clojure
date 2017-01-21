(ns bowling.core-test
  (:use midje.sweet)
  (:use [bowling.core]))

(facts "about bowling score"
       (let [a-gutter-game [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
         (fact "it scores a gutter game"
               (score a-gutter-game) => 0))
       (let [an-all-ones-game [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]]
         (fact "it scores an all ones game"
               (score an-all-ones-game) => 20))
       (let [a-game-with-a-spare [5 5 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
         (fact "it scores a game with a spare"
               (score a-game-with-a-spare) => 16))
       (let [a-game-with-a-strike [10 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
         (fact "it scores a game with a strike"
               (score a-game-with-a-strike) => 24)))
