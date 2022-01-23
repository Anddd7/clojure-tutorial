(ns clojure-tutorial.functions)

;(defn parting                                               ; method name
;  "returns a String parting"                                ; docs
;  [name]                                                    ; parameters
;  (str "Goodbye, " name))                                   ; concat

(defn- private-parting
  "can only be used in this namespace"
  [name]
  (str "Quite, " name))

; 多参数
(defn power [base & exponents]                              ; & 表示可选参数; & list, 将可选参数放到一个列表里
  (reduce #(Math/pow %1 %2) base exponents))                ; # 匿名函数, 调用java.math

(println (power 2 3 4))                                     ; -> 4096.0

;(defn -main [])

; 多态, 动态参数列表 (按参数个数重载
(defn parting
  "returns a string parting in a given language"
  ([] (parting "World"))                                    ; 多态
  ([name] (parting name "en"))
  ([name language]
   (condp = language                                        ; switch case
     "en" (str "Goodbye, " name)
     "es" (str "Adios, " name)
     "zh" (str "再见, " name)
     (throw (IllegalArgumentException. (str "Unsupported language " + language))))))

; 多态, (按参数类型重载
(defmulti what-am-i class)                                  ; dispatch的入参class
(defmethod what-am-i Number [arg] (println arg "is a Number"))
(defmethod what-am-i String [arg] (println arg "is a String"))
(defmethod what-am-i :default [arg] (println arg "is a something"))

; 匿名
(def years [1940 1944 1961 1985 1987])
(filter #(even? %) years)                                   ; (filter (fn [year] (even? year)) years)

; 函数式
(defn callback1 [n1 n2 n3] (+ n1 n2 n3))
(defn callback2 [n1 _ n3] (+ n1 n3))
(defn caller [callback value] (callback (+ value 1) (+ value 2) (+ value 3)))
(caller callback1 10)                                       ; 11 + 12 + 13 -> 36
(caller callback2 10)                                       ; 11 + 13 -> 24

; 函数式取反
(defn teenager? [age] (and (>= age 13) (< age 20)))
(def non-teen? (complement teenager?))
(println (non-teen? 47))

; 函数式 管道 链式调用, 后缀执行
(defn times2 [n] (* n 2))
(defn minus3 [n] (- n 3))
(def my-composition (comp minus3 times2))
(my-composition 4)                                          ; 4*2 - 3 -> 5

; 函数式 插入参数, (partial f arg) -> (f arg ...) 将arg始终作为调用f的第一个参数
(def alwaystimes2 (partial * 2))                            ; alwaystimes2 = (* 2 ...)
(alwaystimes2 3 4)                                          ; alwaystimes2 = (* 2 3 4)


; memoize function - 看起来优化并不是特别明显
(defn- polynomial
  "computes the value of a polynomial
   with the given coefficients for a given value x"
  [coefs x]
  (reduce #(+ (* x %1) %2) coefs))
(def f (partial polynomial [2 1 3]))
(def memo-f (memoize f))

(println "priming call")
(time (f 2))

(println "without memoization")
(dotimes [_ 3] (time (f 2)))

(println "with memoization")
(dotimes [_ 3] (time (memo-f 2)))
