(ns clojure-tutorial.threads)

(defn delayed-print [ms text]
  (Thread/sleep ms)
  (println text))

; clj所有方法默认都是runnable, 可以直接放到Thread的构造函数内

(defn run []
  (delayed-print 1000 ", World!"))
(.start (Thread. run))

(.start (Thread. #(delayed-print 1000 ", World!")))

(.start (Thread. (fn [] (delayed-print 1000 ", World!"))))

(print "Hello")

(defn -main [])
