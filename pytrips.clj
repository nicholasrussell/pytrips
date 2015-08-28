(defn pytrips [t]
  "Returns the three numbers of a Pythagorean triple which add up to t
  (pytrips 1000) -> [375 200 425]
  Note that this uses an algorithm that will only find primitive Pythagorean triples
  Also note that the fixed-point combinator was just 'for funsies'"
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
                 (recur 1 (+ m 1))))))))) 1 2))

(let
  [[a b c] (pytrips 1000)
   p (* a b c)]
  (println a "*" b "*" c "=" p)
  p)
