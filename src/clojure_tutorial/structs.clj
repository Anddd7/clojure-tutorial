(ns clojure-tutorial.structs)

(defstruct vehicle-struct :make :model :year :color)        ; pojo class
(def vehicle (struct vehicle-struct "Toyota" "Prius" 2009)) ; instance

(def make (accessor vehicle-struct :make))                  ; getXXX(Struct.() -> property), 比 map.get 要快
(make vehicle)                                              ; vehicle.getMake()
(vehicle :make)                                             ; getByMake, map.get, 比上面的慢
