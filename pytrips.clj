(defn pytrips [t]
  (let 
    [[a b c]
        (((fn [f]
            ((fn [x]
             (f (fn [& y] (apply (x x) y))))
            (fn [x]
             (f (fn [& y] (apply (x x) y))))))
          (fn [f]
            (fn [n m]
              (if (> m t)
                [0 0 0]
                (let [a (- (* m m) (* n n))
                      b (* 2 m n)
                      c (+ (* m m) (* n n))]
                  (if (and (= (+ a b c) t) (= (+ (* a a) (* b b)) (* c c)))
                    [a b c]
                    (if (< n (- m 1))
                      (recur (+ n 1) m)
                      (recur 1 (+ m 1))))))))) 1 2)]
    (println a "*" b "*" c "=" (* a b c))
    (* a b c)))

(pytrips 1000)