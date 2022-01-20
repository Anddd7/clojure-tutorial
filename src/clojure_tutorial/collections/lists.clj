(ns clojure-tutorial.collections.lists)

; 列表, 链表
; (def stooges (list "Moe" "Larry" "Curly"))
; (def stooges (quote ("Moe" "Larry" "Curly")))
(def stooges '("Moe" "Larry" "Curly"))

; conj join or append first?? 插入到首位
;(def more-stooges (conj stooges "Shemp"))

; cons, 替换一下参数方向
(def more-stooges (cons "Shemp" stooges))

; cons, remove when lambda = true
(def less-stooges (remove #(= % "Curly") more-stooges))

(println stooges more-stooges less-stooges)

(def kids-of-mike '("Greg" "Peter" "Bobby"))
(def kids-of-carol '("Marcia" "Jan" "Cindy"))
(def brady-bunch (into kids-of-mike kids-of-carol))         ; concat

(println brady-bunch)

(defn -main [])
