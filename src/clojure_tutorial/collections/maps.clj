(ns clojure-tutorial.collections.maps)


(def stooges #{"Moe" "Larry" "Curly"})                      ; (def stooges (hash-set "Moe" "Larry" "Curly"))
(def stooges-sorted (sorted-set "Moe" "Larry" "Curly"))

(println
  (contains? stooges "Moe"))                                ; contains 用在 lists 和 vectors 时表现会不太一样
(println
  (contains? stooges "Mark"))

(println
  (stooges "Moe"))                                          ; get by key
(println
  (stooges "Mark"))

(def more-stooges
  (conj stooges "Shemp"))
(def less-stooges
  (disj stooges "Curly"))


(def popsicle-map
  {:red :cherry, :green :apple, :purple :grape})            ; (def popsicle-map (hash-map :red :cherry, :green :apple, :purple :grape))

(println
  (get popsicle-map :green))

(def new-map
  (assoc popsicle-map :green :lime "blue" "blueberry"))     ; put reference or string as the key

(println
  (get new-map :green))
(println
  (get new-map :blue))
(println
  (get new-map "blue"))


(doseq [[color flavor] popsicle-map]                        ; doseq [entry-binding map], binding可以被解构
  (println
    (str
      "The flavor of " (name color) " "
      "popsicles is " (name flavor) ".")))

; nested map
(def person {:name     "Mark Volkmann"
             :address  {:street "644 Glen Summit"
                        :city   "St. Charles"
                        :state  "Missouri"
                        :zip    63304}
             :employer {:name    "Object Computing, Inc."
                        :address {:street "12140 Woodcrest Executive Drive, Suite 250"
                                  :city   "Creve Coeur"
                                  :state  "Missouri"
                                  :zip    63141}}})
; get data in nested map
(get-in person [:employer :address :city])                  ; 函数
(-> person :employer :address :city)                        ; thread宏, 前一个的结果是后一个的输入, pipe


(defn -main [])
