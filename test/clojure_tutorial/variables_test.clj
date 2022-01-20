(ns clojure-tutorial.variables-test
  (:require [clojure.test :refer :all])
  (:require [clojure-tutorial.variables :refer :all]))

(deftest a-test
  (testing "just try f1"
    (f1)
    (is (= v 1)))
  (testing "just try f2"
    (f2)
    (is (= v 1)))
  (testing "just try f3"
    (f3)
    (is (= v 1)))
  (testing "just try f4"
    (f4)
    (is (= v 4))))
