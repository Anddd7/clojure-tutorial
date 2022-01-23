(ns clojure-tutorial.functions-test
  (:require [clojure.test :refer :all])
  (:require [clojure-tutorial.functions :refer [f]]))

(deftest f-test
  (testing "just a test"
    (is (= 0 0))))
