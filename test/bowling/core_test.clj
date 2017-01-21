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
       (let [a-game-starting-with-a-spare [5 5 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
         (fact "it scores a game starting with a spare"
               (score a-game-starting-with-a-spare) => 16))
       (let [a-game-starting-with-a-strike [10 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
         (fact "it scores a game starting with a strike"
               (score a-game-starting-with-a-strike) => 24))
       (let [a-perfect-game [10 10 10 10 10 10 10 10 10 10 10 10]]
         (fact "it scores a perfect game"
               (score a-perfect-game) => 300))
       (let [an-all-spares-game [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 10]]
         (fact "it scores an all spares game"
               (score an-all-spares-game) => 155))
       (let [an-game-with-a-strike [0 0 10 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
         (fact "it scores a game with a strike"
               (score an-game-with-a-strike) => 24)))
