(let 
  [n 1000
   [a b c]
      (((fn [f]
          ((fn [x]
           (f (fn [& y] (apply (x x) y))))
          (fn [x]
           (f (fn [& y] (apply (x x) y))))))
        (fn [f]
          (fn [a b c]
            (when (< a n) ; n - 4, n - 2
              (if (and
                    (= (+ a b c) n)
                    (and (and (< a b) (< b c)) (= (+ (* a a) (* b b)) (* c c))))
                [a b c]
                (let [[a b c]
                        (if (< c n) ; n - 2
                          [a b (+ c 1)]
                          (if (< b n) ; n - 3, n - 1
                            [a (+ b 1) (+ b 2)]
                            [(+ a 1) (+ a 2) (+ a 3)]))]
                  (recur a b c))))))) 1 2 3)]
  (println a "*" b "*" c "=" (* a b c))
  (* a b c))