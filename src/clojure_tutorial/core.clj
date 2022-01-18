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


; define set with items
(def vowel? (set "aeiou"))

; define function [input]
(defn pig-latin [word]
  ; define variable = first(word)
  (let [first-letter (first word)]
    ; if set.contains
    (if (vowel? first-letter)
      ; then str = word + "ay"
      (str word "ay")
      ; else str = word[1:] + word[0] + "ay"
      (str (subs word 1) first-letter "ay"))))

; run it along with this script
(println (pig-latin "red"))
(println (pig-latin "orange"))
