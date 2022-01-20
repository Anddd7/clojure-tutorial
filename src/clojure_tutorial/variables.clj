(ns clojure-tutorial.variables)

(def ^:dynamic v 1)                                         ; v is a global binding

(defn f1 []
  (println "f1: v = " v))                                   ; global binding function

(defn f2 []                                                 ; f2 会执行三个表达式块
  (println "f2: before let v = " v)                         ; v=1
  (let [v 2]                                                ; local binding, shadows global one
    (println "f2: in let, v = " v)                          ; v=2, 只在当前块内直接引用 v 时生效
    (f1))                                                   ; 执行 f1 函数, 脱离 let 块, v=1
  (println "f2: after let v = " v))                         ; v=1

(defn f3 []
  (println "f3: before binding v = " v)                     ; v=1
  (binding [v 3]                                            ; same global binding, but temporarily
    (println "f3: in binding, v = " v)                      ; v=3, 在当前域(括号)内生效
    (f1))                                                   ; v=3, f1 在 binding 域内执行
  (println "f3: after binding v = " v))                     ; v=1, 脱离 binding 域, 值恢复

(defn f4 []
  (def v 4)                                                 ; 重新对 v 进行赋值, v 已被全局改变
  (f1)
  (println "after calling f4, v =" v))
