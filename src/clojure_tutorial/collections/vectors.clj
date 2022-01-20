(ns clojure-tutorial.collections.vectors)

; 向量 = array list = 数组
(def stooges ["Moe" "Larry" "Curly"])                       ; (def stooges (vector "Moe" "Larry" "Curly"))

(println
  (get stooges 1))
(println
  (get stooges 3))                                          ; return nil
(println
  (get stooges 3 "unknown"))                                ; return default value

(println
  (assoc stooges 2 "Shemp"))                                ; 替换 or 新增元素到指定位置
(println
  (assoc stooges 3 "Tester"))

(println
  (nth stooges 3 "unknown"))
(println
  (nth stooges 3))                                          ; throw exception


(defn -main [])
