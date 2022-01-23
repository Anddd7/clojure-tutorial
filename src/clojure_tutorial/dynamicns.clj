(ns clojure-tutorial.dynamicns)

(def foo 1)
(create-ns 'com.github.anddd7)                              ; 创建一个ns(动态的)
(intern 'com.github.anddd7 'foo 2)                          ; 在动态的ns里定义一个变量

(println (+ foo com.github.anddd7/foo))                     ; 调用不同ns的值进行操作

(println (ns-interns 'com.github.anddd7))                   ; list dynamic ns 的 所有变量

