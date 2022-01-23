(ns clojure-tutorial.namespaces)
(require 'clojure-tutorial.core)                            ; require = import ns
(use 'clojure-tutorial.functions)                           ; use = require + refer = import ns.*

(clojure-tutorial.core/pig-latin "red")
(parting "test parting from another ns")
;(private-parting "invalid") ; will throw exception

;(defn -main [])
