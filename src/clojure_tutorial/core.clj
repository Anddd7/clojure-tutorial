(ns clojure-tutorial.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

; main function
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (prn "Hello, World!"))
