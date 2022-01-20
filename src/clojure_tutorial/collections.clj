(ns clojure-tutorial.collections)

; 不可变, 异源, 持久
; immutable, no generic, versional

(println "count"
         (count [19 "yellow" true]))

(println "reverse"
         (reverse [2 4 7]))

; (map #(expr) seq)
; = seq.map(expr)
(println "map I"
         (map #(+ % 3) [2 4 7]))                            ; `#`匿名函数标识; `%`入参占位符;
(println "map II"
         (map + [2 4 7] [5 6] [1 2 3 4]))                   ; 以最少元素的集合为准 for i<min(length)

; reduce??
(println "apply"
         (apply + [1 2 3]))

(def stooges ["Moe" "Larry" "Curly" "Shemp"])
(println "array I"
         (first stooges)
         (second stooges)
         (last stooges)
         (nth stooges 2))

(println "array II"
         (next stooges)                                     ; [1:], exclude first
         (butlast stooges)                                  ; [:n-1], exclude last
         (drop-last 2 stooges)
         (filter #(> (count %) 3) stooges)                  ; keep strings which length > 3
         (nthnext stooges 2))                               ; [2:]

; stream, sequence like
; ps. `some?` `any?` 并不是集合操作
(println "stream"
         (every? #(instance? String %) stooges)             ; verify all item are instance of string
         (not-every? #(instance? String %) stooges)         ; all not string
         (some #(instance? Number %) stooges)               ; get first number
         (not-any? #(instance? Number %) stooges))          ; no one is number; all not number

(defn -main [])                                             ; execute all
